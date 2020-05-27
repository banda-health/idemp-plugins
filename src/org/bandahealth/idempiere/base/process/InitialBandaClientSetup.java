package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.process.InitialClientSetup;
import org.bandahealth.idempiere.base.model.MBandaSetup;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.compiere.Adempiere;
import org.compiere.impexp.ImpFormat;
import org.compiere.impexp.MImpFormat;
import org.compiere.model.MElement;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.ImportAccount;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;


/**
 * Process to extend the Initial iDempiere client setup with Banda stuff
 */
public class InitialBandaClientSetup extends InitialClientSetup {

	public static final String CLIENTLEVEL_BASIC = "B";
	public static final String CLIENTLEVEL_INTERMEDIATE = "I";
	public static final String CLIENTLEVEL_ADVANCED = "A";

	private boolean wantsCashBoxAccount = false;
	private boolean wantsMobileAccount = false;
	private boolean wantsSavingsAccount = false;
	private String clientName = null;
	private String orgName = null;
	private String clientLevel = CLIENTLEVEL_BASIC;

	private int usersClientId;

	// [$IDEMPIERE-HOME]/data/import/
	private final String coaInitialAccountsFile = Adempiere.getAdempiereHome() + File.separator + "data"
			+ File.separator + "import"
			+ File.separator + "Accounting_COA_Temp_99999 - Accounting_All_Same.csv";
	private final String coaBandaFile = Adempiere.getAdempiereHome() + File.separator + "data"
			+ File.separator + "import"
			+ File.separator + "BandaGoChartofAccounts-Basic.csv";

	/**
	 * Prepare
	 */
	protected void prepare() {
		usersClientId = getAD_Client_ID();

		addCoAFileValueToParametersBasedOnClientType();

		super.prepare();

		ProcessInfoParameter[] para = getParameter();
		for (ProcessInfoParameter processInfoParameter : para) {
			String name = processInfoParameter.getParameterName();
			if (processInfoParameter.getParameter() == null) {
				continue;
			}
			switch (name) {
				case "IsUsingCashBox":
					wantsCashBoxAccount = processInfoParameter.getParameterAsBoolean();
					break;
				case "IsUsingMobile":
					wantsMobileAccount = processInfoParameter.getParameterAsBoolean();
					break;
				case "IsUsingSavings":
					wantsSavingsAccount = processInfoParameter.getParameterAsBoolean();
					break;
				case "ClientName":
					clientName = processInfoParameter.getParameterAsString();
					break;
				case "OrgName":
					orgName = processInfoParameter.getParameterAsString();
					break;
				case "ClientLevel":
					clientLevel = processInfoParameter.getParameterAsString();
					break;
			}
		}
	}

	/**
	 * 	Process to automate the work done previously:
	 * 		1. Create a client with the account "DO NOT USE" assigned to every default in the accounting schema
	 * 		2. Import the desired CoA (Basic, Intermediate, Advanced)
	 * 		3. Update default account mapping (i.e. set B_Asset = B_InTransit, etc.)
	 * 		4. Create bank accounts for the client
	 * 		5. Create and map Payment Types to the default Bank Account
	 * 		6. Insert default Expense Categories (charges) for the client
	 * 		7. Create default product categories for products so they hit the correct revenue accounts
	 *	@return info
	 *	@throws Exception
	 */
	protected String doIt() throws Exception {
		String completeInfo = super.doIt();

		MBandaSetup bandaSetup = new MBandaSetup(getCtx(), clientName, orgName);
		if (bandaSetup.getAccountSchema() == null ||
				bandaSetup.getAD_Client_ID() == -1 || bandaSetup.getAD_Org_ID() == -1
		) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Initial client setup incomplete"));
		}

		// Set the client ID for this process so everyone gets the same ID from here, ctx, or wherever
		getProcessInfo().setAD_Client_ID(bandaSetup.getAD_Client_ID());
		try {
			if (!importCoA(getCoAFileToImport())) {
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Inserting Banda Accounts failed"));
			}

			addImportAccountParameters(bandaSetup);
			// Kick off the account import process
			ImportAccount importAccountProcess = new ImportAccount();
			// Leave the transaction null so it will create a local one, save it, and commit it after all work is done
			importAccountProcess.startProcess(getCtx(), getProcessInfo(), null);

			// Start our own transaction
			bandaSetup.start();

			if (!bandaSetup.updateDefaultAccountMapping()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Update default mapping failed"));
			}
			addLog(bandaSetup.getInfo());

			if (!bandaSetup.createBankAccounts(wantsCashBoxAccount, wantsMobileAccount, wantsSavingsAccount)) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Create bank accounts failed"));
			}
			addLog(bandaSetup.getInfo());

			if (!bandaSetup.addDefaultCharges()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Create default charges failed"));
			}
			addLog(bandaSetup.getInfo());

			if (!bandaSetup.createDefaultProductCategories()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Create default product categories failed"));
			}
			addLog(bandaSetup.getInfo());

			if (!bandaSetup.finish()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Failed to save Banda additions"));
			}
		} catch (Exception e) {
			rollback(bandaSetup);
			throw e;
		}

		resetClientId();

		return completeInfo;
	}

	private void rollback(MBandaSetup bandaSetup) {
		resetClientId();
		bandaSetup.rollback();
	}

	private void resetClientId() {
		getProcessInfo().setAD_Client_ID(usersClientId);
		Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, usersClientId);
	}

	/**
	 * This emulates the process found in WFileImport.java and the screen "Import File Loader" to upload
	 * an account file into the system
	 * @param coaFileToImport The URI of the file to upload
	 * @return True if the import succeeds
	 * @throws IOException
	 * @throws SQLException
	 */
	private boolean importCoA(String coaFileToImport) throws IOException, SQLException {
		// We'll create a local transaction for this because it'll be needed later
		Trx localTrx = Trx.get(Trx.createTrxName("Setup_accountImport"), true);
		localTrx.start();

		MImpFormat accountingFormat = new Query(
				getCtx(),
				MImpFormat.Table_Name,
				MImpFormat.COLUMNNAME_AD_ImpFormat_UU + "=?",
				localTrx.getTrxName()
		)
				.setParameters(MBandaSetup.IMPORTFORMAT_ACCOUNTING_ACCOUNTS_UU)
				.first();

		if (accountingFormat == null) {
			String err = "Accounting Format do not exist";
			log.log(Level.SEVERE, err);
			addLog(err);
			localTrx.close();
			return false;
		}

		// First, we need to use the "Import File Loader" process to pull in our mappings
		ImpFormat coaFormat = ImpFormat.load(accountingFormat.getAD_ImpFormat_ID());
		File coaFile = new File(coaFileToImport);
		BufferedReader reader = new BufferedReader(new FileReader(coaFile));
		String line;
		int importedRows = 0;
		int totalRows = 0;
		while ((line = reader.readLine()) != null) {
			totalRows++;
			// Skip the header line, if it's present
			if (line.contains("[Account_Value]")) {
				continue;
			}
			if (coaFormat.updateDB(getCtx(), line, localTrx.getTrxName())) {
				importedRows++;
			}
		}
		reader.close();
		addLog("Imported " + importedRows + " of " + totalRows + " rows of the Banda CoA file.");

		boolean success = localTrx.commit(false);
		localTrx.close();
		return success;
	}

	/**
	 * Adds the fields ImportAccount.java needs to import the accounts uploaded
	 */
	private void addImportAccountParameters(MBandaSetup bandaSetup) {
		int elementId = new Query(
				getCtx(),
				MElement.Table_Name,
				MElement.COLUMNNAME_AD_Client_ID + "=?",
				null
		)
				.setParameters(bandaSetup.getAD_Client_ID())
				.firstId();

		if (elementId == -1) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "C_Element doesn't exist for client"));
		}
		// The process likes it's client ID as a BigDecimal for some reason
		addParameter(new ProcessInfoParameter("AD_Client_ID", new BigDecimal(bandaSetup.getAD_Client_ID()),
				null, null, null));
		// The process likes it's C_Element_ID as a BigDecimal for some reason
		addParameter(new ProcessInfoParameter("C_Element_ID", new BigDecimal(elementId),
				null, null, null));
		addParameter(new ProcessInfoParameter("UpdateDefaultAccounts", "Y",
				null, null, null));
		addParameter(new ProcessInfoParameter("CreateNewCombination", "Y",
				null, null, null));
		addParameter(new ProcessInfoParameter("DeleteOldImported", "Y",
				null, null, null));
	}

	/**
	 * Adds the fields InitialClientSetup.java needs to read the initial CoA file
	 */
	private void addCoAFileValueToParametersBasedOnClientType() {
		addParameter(new ProcessInfoParameter(
				"CoAFile",
				MSysConfig.getValue(MSysConfig_BH.DEFAULT_BASIC_COA_PATH, coaInitialAccountsFile),
				null,
				null,
				null
		));
		addParameter(new ProcessInfoParameter("UseDefaultCoA", "N",
				null, null, null));
	}

	private String getCoAFileToImport() {
		String coaImportFile = MSysConfig.getValue(MSysConfig_BH.DEFAULT_BASIC_COA_PATH,
				coaBandaFile);
		if (CLIENTLEVEL_INTERMEDIATE.equalsIgnoreCase(clientLevel)) {
			coaImportFile = MSysConfig.getValue(MSysConfig_BH.DEFAULT_INTERMEDIATE_COA_PATH,
					coaBandaFile);
		} else if (CLIENTLEVEL_ADVANCED.equalsIgnoreCase(clientLevel)) {
			coaImportFile = MSysConfig.getValue(MSysConfig_BH.DEFAULT_ADVANCED_COA_PATH,
					coaBandaFile);
		}
		return coaImportFile;
	}

	private void addParameter(ProcessInfoParameter parameter) {
		List<ProcessInfoParameter> parameters = new ArrayList<ProcessInfoParameter>(Arrays.asList(getParameter()));
		parameters.add(parameter);
		// Set the parameters so they can be accessed by everyone
		getProcessInfo().setParameter(parameters.toArray(ProcessInfoParameter[]::new));
	}
}
