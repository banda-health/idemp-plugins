package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.process.InitialClientSetup;
import org.bandahealth.idempiere.base.model.MBandaSetup;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MRole_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.Adempiere;
import org.compiere.impexp.ImpFormat;
import org.compiere.impexp.MImpFormat;
import org.compiere.model.MClient;
import org.compiere.model.MElement;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
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
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;


/**
 * Process to extend the Initial iDempiere client setup with Banda stuff
 */
public class InitialBandaClientSetup extends InitialClientSetup {

	public static final String CLIENTLEVEL_BASIC = "B";
	public static final String CLIENTLEVEL_INTERMEDIATE = "I";
	public static final String CLIENTLEVEL_ADVANCED = "A";

	public static final String PARAMETERNAME_IS_USING_CASH_BOX = "IsUsingCashBox";
	public static final String PARAMETERNAME_IS_USING_MOBILE = "IsUsingMobile";
	public static final String PARAMETERNAME_IS_USING_SAVINGS = "IsUsingSavings";
	public static final String PARAMETERNAME_CLIENT_NAME = "ClientName";
	public static final String PARAMETERNAME_ORG_NAME = "OrgName";
	public static final String PARAMETERNAME_CLIENT_LEVEL = "ClientLevel";
	public static final String PARAMETERNAME_AD_CLIENT_ID = "AD_Client_ID";
	public static final String PARAMETERNAME_C_ELEMENT_ID = "C_Element_ID";
	public static final String PARAMETERNAME_UPDATE_DEFAULT_ACCOUNTS = "UpdateDefaultAccounts";
	public static final String PARAMETERNAME_CREATE_NEW_COMBINATION = "CreateNewCombination";
	public static final String PARAMETERNAME_DELETE_OLD_IMPORTED = "DeleteOldImported";
	public static final String PARAMETERNAME_COA_FILE = "CoAFile";
	public static final String PARAMETERNAME_USE_DEFAULT_COA = "UseDefaultCoA";
	public static final String PARAMETERNAME_ADMIN_USER_NAME = "AdminUserName";
	public static final String PARAMETERNAME_NORMAL_USER_NAME = "NormalUserName";
	public static final String PARAMETERNAME_ADMIN_EMAIL = "AdminUserEmail";
	public static final String PARAMETERNAME_USER_EMAIL = "NormalUserEmail";
	private final String PREFIX_PROCESS_TRANSACTION_NAME = "Setup_accountImport";
	// [$IDEMPIERE-HOME]/data/import/
	private final String coaInitialAccountsFile = Adempiere.getAdempiereHome() + File.separator + "data"
			+ File.separator + "import"
			+ File.separator + "Accounting_COA_Temp_99999 - Accounting_All_Same.csv";
	private final String coaBandaFile = Adempiere.getAdempiereHome() + File.separator + "data"
			+ File.separator + "import"
			+ File.separator + "BandaGoChartofAccounts-Basic.csv";
	private final String SALES_PRICE_LIST_NAME = "Sales";
	private final String SALES_PRICE_LIST_VERSION_NAME = "Sales PriceList Version 1";
	private final String PURCHASES_PRICE_LIST_NAME = "Purchase";
	private final String PURCHASES_PRICE_LIST_VERSION_NAME = "Purchases PriceList Version 1";
	private boolean wantsCashBoxAccount = false;
	private boolean wantsMobileAccount = false;
	private boolean wantsSavingsAccount = false;
	private String clientName = null;
	private String orgName = null;
	private String adminUserName = null;
	private String clientLevel = CLIENTLEVEL_BASIC;
	private int usersClientId;

	/**
	 * Prepare
	 */
	protected void prepare() {
		usersClientId = getAD_Client_ID();

		addCoAFileValueToParametersBasedOnClientType();
		ProcessInfoParameter[] para = getParameter();
		for (ProcessInfoParameter processInfoParameter : para) {
			String name = processInfoParameter.getParameterName();
			if (processInfoParameter.getParameter() == null) {
				continue;
			}
			switch (name) {
				case PARAMETERNAME_IS_USING_CASH_BOX:
					wantsCashBoxAccount = processInfoParameter.getParameterAsBoolean();
					break;
				case PARAMETERNAME_IS_USING_MOBILE:
					wantsMobileAccount = processInfoParameter.getParameterAsBoolean();
					break;
				case PARAMETERNAME_IS_USING_SAVINGS:
					wantsSavingsAccount = processInfoParameter.getParameterAsBoolean();
					break;
				case PARAMETERNAME_CLIENT_NAME:
					//org name is same as client name
					clientName = processInfoParameter.getParameterAsString();
					orgName = processInfoParameter.getParameterAsString();
					break;
				case PARAMETERNAME_CLIENT_LEVEL:
					clientLevel = processInfoParameter.getParameterAsString();
					break;
			}
		}
		addAutomatedParameters();
		super.prepare();


	}

	/**
	 * Process to automate the work done previously:
	 * 1. Create a client with the account "DO NOT USE" assigned to every default in the accounting schema
	 * 2. Import the desired CoA (Basic, Intermediate, Advanced)
	 * 3. Update default account mapping (i.e. set B_Asset = B_InTransit, etc.)
	 * 4. Create bank accounts for the client
	 * 5. Create and map Payment Types to the default Bank Account
	 * 6. Insert default Expense Categories (charges) for the client
	 * 7. Create default product categories for products so they hit the correct revenue accounts
	 * 8. Update the organization name and key
	 * 9. Add custom warehouse and address
	 * 10. Create default sales and purchases price-lists
	 * 11. Update calendar control
	 * 12. Update users setup
	 *
	 * @return info
	 * @throws Exception
	 */
	protected String doIt() throws Exception {
		String completeInfo = super.doIt();

		MClient client = new Query(getCtx(), MClient.Table_Name, MClient.COLUMNNAME_Name + "=?", get_TrxName())
				.setParameters(clientName).first();
		MOrg organization =
				new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_Name + "=? AND " + MOrg.COLUMNNAME_AD_Client_ID + "=?",
						get_TrxName()).setParameters(orgName, client.getAD_Client_ID()).first();

		MBandaSetup bandaSetup = new MBandaSetup(getCtx(), client, organization);
		// If AD_Client_ID or AD_Org_ID are -1, something went wrong in setup, but no error was generated
		// If this happens, we want to throw an error
		if (bandaSetup.getAccountSchema() == null ||
				bandaSetup.getAD_Client_ID() == -1 || bandaSetup.getAD_Org_ID() == -1
		) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Initial client setup incomplete"));
		}

		// Set the client ID for this process so everyone gets the same ID from here, ctx, or wherever
		getProcessInfo().setAD_Client_ID(bandaSetup.getAD_Client_ID());
		Env.setContext(getCtx(), Env.AD_CLIENT_ID, bandaSetup.getAD_Client_ID());
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

			if (!bandaSetup.updateAccountingSchemaCosting()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Update accounting schema costing failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			if (!bandaSetup.updateDefaultAccountMapping()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Update default mapping failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			if (!bandaSetup.createBankAccounts(wantsCashBoxAccount, wantsMobileAccount, wantsSavingsAccount)) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Create bank accounts failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			if (!bandaSetup.addDefaultCharges()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Create default charges failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			if (!bandaSetup.createDefaultProductCategories()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Create default product categories failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			// Update the user role that iDempiere automatically created
			if (!bandaSetup.resetUserRole()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Reset user role failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			List<MUser_BH> usersToAddRolesTo = new ArrayList<>();
			MUser_BH clientAdminUser = new Query(getCtx(), MUser.Table_Name,
					MUser_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MUser_BH.COLUMNNAME_Name + "=?", get_TrxName())
					.setParameters(bandaSetup.getAD_Client_ID(), adminUserName).first();
			if (clientAdminUser != null) {
				usersToAddRolesTo.add(clientAdminUser);
			}
			if (!bandaSetup.initializeRoles(usersToAddRolesTo)) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Initialization of roles failed"));
			}
			if (!bandaSetup.updateWarehouseLocatorSetUp()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Warehouse setup failed"));
			}
			if (!bandaSetup.createPriceList(PURCHASES_PRICE_LIST_NAME, PURCHASES_PRICE_LIST_VERSION_NAME, false)) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Purchase Price List Setup failed"));
			}
			if (!bandaSetup.createPriceList(SALES_PRICE_LIST_NAME, SALES_PRICE_LIST_VERSION_NAME, true)) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Sales Price List setup failed"));
			}
			if (!bandaSetup.openCalendarYearPeriods()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Open calendar periods failed"));
			}
			if (!bandaSetup.configureClientUsers()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Remove default business partners failed"));
			}
			addLog(bandaSetup.getThenResetInfo());

			if (!bandaSetup.createProductAttributeSets()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Creating attribute sets failed"));
			}
			
			if (!bandaSetup.createDefaultBusinessPartners()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Creating default business partners failed"));
			}

			if (!bandaSetup.finish()) {
				rollback(bandaSetup);
				throw new AdempiereException(Msg.getMsg(Env.getCtx(), "Failed to save Banda additions"));
			}
		} catch (Exception e) {
			rollback(bandaSetup);
			throw e;
		}

		addCreatedUserRolesToLoggedInUser(bandaSetup.getAD_Client_ID(), bandaSetup.getAD_Org_ID());

		/**
		 * The context has it's AD_Client_ID replaced with the generated one. If the user continues using iDempiere,
		 * they're AD_Client_ID will be wrong (since they should be "System") and they'll have to log out and log
		 * back in to fix it. Instead, just reset the client ID in the context to what it was before the process
		 * started.
		 */
		resetClientId();

		return completeInfo;
	}

	/**
	 * Roles are currently added to the SuperUser user, which the logged-in user may not be. So, add them to the
	 * logged-in user
	 */
	private void addCreatedUserRolesToLoggedInUser(int clientId, int orgId) {
		List<MRole> clientRoles = new Query(getCtx(), MRole.Table_Name, MRole.COLUMNNAME_AD_Client_ID + "=?",
				get_TrxName()).setParameters(clientId).list();

		List<Object> parameters = clientRoles.stream().map(MRole::getAD_Role_ID).collect(Collectors.toList());

		List<MUser_BH> systemAdministrators = new Query(getCtx(), MUser_BH.Table_Name,
				MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID + " >= ? AND " + MUserRoles.Table_Name + "."
						+ MUserRoles.COLUMNNAME_AD_Role_ID + "=? ",
				get_TrxName())
				.addJoinClause("JOIN " + MUserRoles.Table_Name + " ON " + MUser_BH.Table_Name + "."
						+ MUser_BH.COLUMNNAME_AD_User_ID + " = " + MUserRoles.Table_Name + "."
						+ MUserRoles.COLUMNNAME_AD_User_ID)
				.setParameters(MClient_BH.CLIENTID_LAST_SYSTEM, MRole_BH.SYSTEM_ROLE_ID).list();
		Set<Integer> systemUsersToAdd = systemAdministrators.stream().map(MUser_BH::get_ID).collect(Collectors.toSet());

		String whereClause = "?,".repeat(clientRoles.size());
		whereClause = whereClause.substring(0, whereClause.length() - 1);

		String sysAdminCountWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(systemUsersToAdd, parameters);

		StringBuilder usersAssignedClientRolesWhereClause =
				new StringBuilder(MUserRoles.COLUMNNAME_AD_Role_ID).append(" IN (").append(whereClause).append(")");
		if (!systemUsersToAdd.isEmpty()) {
			usersAssignedClientRolesWhereClause.append(" AND ").append(MUserRoles.COLUMNNAME_AD_User_ID).append(" IN (")
					.append(sysAdminCountWhereClause).append(")");
		}
		List<MUserRoles> usersAssignedClientRoles =
				new Query(getCtx(), MUserRoles.Table_Name, usersAssignedClientRolesWhereClause.toString(),
						get_TrxName()).setParameters(parameters).list();
		// If any roles have already been assigned for this user and client, we don't
		// need to do anything
		if (usersAssignedClientRoles.size() > 0) {
			return;
		}
		for (MUser_BH user : systemAdministrators) {
			clientRoles.forEach(clientRole -> {
				MUserRoles roleToAssign = new MUserRoles(getCtx(), user.get_ID(), clientRole.getAD_Role_ID(),
						get_TrxName());
				roleToAssign.setAD_Org_ID(orgId);
				roleToAssign.saveEx();
			});
		}
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
	 *
	 * @param coaFileToImport The URI of the file to upload
	 * @return True if the import succeeds
	 * @throws IOException
	 * @throws SQLException
	 */
	private boolean importCoA(String coaFileToImport) throws IOException, SQLException {
		// We'll create a local transaction for this because it'll be needed later
		Trx localTransaction = Trx.get(Trx.createTrxName(PREFIX_PROCESS_TRANSACTION_NAME), true);
		localTransaction.start();

		MImpFormat accountingFormat = new Query(
				getCtx(),
				MImpFormat.Table_Name,
				MImpFormat.COLUMNNAME_AD_ImpFormat_UU + "=?",
				localTransaction.getTrxName()
		)
				.setParameters(MBandaSetup.IMPORTFORMAT_ACCOUNTING_ACCOUNTS_UU)
				.first();

		if (accountingFormat == null) {
			String err = "Accounting Format do not exist";
			log.log(Level.SEVERE, err);
			addLog(err);
			localTransaction.close();
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
			if (coaFormat.updateDB(getCtx(), line, localTransaction.getTrxName())) {
				importedRows++;
			}
		}
		reader.close();
		addLog("Imported " + importedRows + " of " + totalRows + " rows of the Banda CoA file.");

		boolean success = localTransaction.commit(false);
		localTransaction.close();
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
		addParameter(new ProcessInfoParameter(PARAMETERNAME_AD_CLIENT_ID, new BigDecimal(bandaSetup.getAD_Client_ID()),
				null, null, null));
		// The process likes it's C_Element_ID as a BigDecimal for some reason
		addParameter(new ProcessInfoParameter(PARAMETERNAME_C_ELEMENT_ID, new BigDecimal(elementId),
				null, null, null));
		addParameter(new ProcessInfoParameter(PARAMETERNAME_UPDATE_DEFAULT_ACCOUNTS, "Y",
				null, null, null));
		addParameter(new ProcessInfoParameter(PARAMETERNAME_CREATE_NEW_COMBINATION, "Y",
				null, null, null));
		addParameter(new ProcessInfoParameter(PARAMETERNAME_DELETE_OLD_IMPORTED, "Y",
				null, null, null));
	}

	/**
	 * Adds the fields InitialClientSetup.java needs to read the initial CoA file
	 */
	private void addCoAFileValueToParametersBasedOnClientType() {
		addParameter(new ProcessInfoParameter(
				PARAMETERNAME_COA_FILE,
				MSysConfig.getValue(MSysConfig_BH.DEFAULT_INITIAL_COA_PATH, coaInitialAccountsFile),
				null,
				null,
				null
		));
		addParameter(new ProcessInfoParameter(PARAMETERNAME_USE_DEFAULT_COA, "N",
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


	/**
	 * Add to parameters dynamically:
	 * admin/user names and email
	 */
	private void addAutomatedParameters() {
		addParameter(new ProcessInfoParameter(PARAMETERNAME_ORG_NAME, clientName, null, null, null));
		String prefix = clientName.replaceAll("\\s", "");
		addParameter(new ProcessInfoParameter(PARAMETERNAME_ADMIN_USER_NAME, prefix + "Admin", null, null, null));
		addParameter(new ProcessInfoParameter(PARAMETERNAME_NORMAL_USER_NAME, prefix + "User", null, null, null));
		addParameter(
				new ProcessInfoParameter(PARAMETERNAME_ADMIN_EMAIL, "admin@" + prefix.toLowerCase() + ".org", null, null,
						null));
		addParameter(
				new ProcessInfoParameter(PARAMETERNAME_USER_EMAIL, "user@" + prefix.toLowerCase() + ".org", null, null, null));
	}

	private void addParameter(ProcessInfoParameter parameter) {
		List<ProcessInfoParameter> parameters = new ArrayList<ProcessInfoParameter>(Arrays.asList(getParameter()));
		parameters.add(parameter);
		// Set the parameters so they can be accessed by everyone
		getProcessInfo().setParameter(parameters.toArray(ProcessInfoParameter[]::new));
	}
}
