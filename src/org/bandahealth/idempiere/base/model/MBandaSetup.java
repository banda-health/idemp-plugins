package org.bandahealth.idempiere.base.model;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.*;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBank;
import org.compiere.model.MBankAccount;
import org.compiere.model.MCalendar;
import org.compiere.model.MClient;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MRefTable;
import org.compiere.model.MReference;
import org.compiere.model.MSetup;
import org.compiere.model.MTable;
import org.compiere.model.NaturalAccountMap;
import org.compiere.model.Query;
import org.compiere.model.X_C_BankAccount_Acct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

public class MBandaSetup {

	public static final String ACCOUNTVALUE_CASH_BOX = "11800";
	public static final String ACCOUNTVALUE_MOBILE = "11400";
	public static final String ACCOUNTVALUE_SAVINGS = "11300";

	public static final String ACCOUNTNAME_DEFAULT = "Default";
	public static final String ACCOUNTNAME_CASH_BOX = "Cash Box";
	public static final String ACCOUNTNAME_MOBILE = "Mobile";
	public static final String ACCOUNTNAME_SAVINGS = "Savings";

	/* The UU of the Payment Reference Reference */
	public static final String REFERENCE_PAYMENT_REF_UU= "5943153c-cf7b-4bd1-96b7-ff36d1c0f860";

	public MBandaSetup(MSetup setup, Properties ctx, int windowNumber) {
		this.ctx = ctx;
		language = Env.getAD_Language(this.ctx);
		this.windowNumber = windowNumber;
		clientId = setup.getAD_Client_ID();
		orgId = setup.getAD_Org_ID();

		accountSchema = new Query(
				this.ctx,
				MAcctSchema.Table_Name,
				MAcctSchema.COLUMNNAME_AD_Client_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(clientId)
				.first();
	}

	protected CLogger log = CLogger.getCLogger(getClass());

	// This transaction code is copied from MSetup.java
	private Trx trx = Trx.get(Trx.createTrxName("Setup"), true);
	private Properties ctx;
	private String language;
	private int windowNumber;
	private StringBuffer info;

	private String m_clientName;

	private String m_stdColumns = "AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy";
	private String m_stdValues;
	private String m_stdValuesOrg;
	//
	private NaturalAccountMap<String, MElementValue> m_nap = null;
	//
	private MClient m_client;
	private int clientId;
	private MOrg m_org;
	private int orgId;
	private MAcctSchema accountSchema;
	//
	private int AD_User_ID;
	private String  		AD_User_Name;
	private int     		AD_User_U_ID;
	private String  		AD_User_U_Name;
	private MCalendar m_calendar;
	private int     		m_AD_Tree_Account_ID;
	private int     		C_Cycle_ID;
	//
	private boolean         m_hasProject = false;
	private boolean         m_hasMCampaign = false;
	private boolean         m_hasSRegion = false;
	private boolean         m_hasActivity = false;

	public boolean createBankAccounts(boolean wantsCashBox, boolean wantsMobile, boolean wantsSavings) {
		MClient client = (MClient) MTable.get(ctx, MClient.Table_ID).getPO(clientId, trx.getTrxName());
		MOrg org = (MOrg) MTable.get(ctx, MOrg.Table_ID).getPO(orgId, trx.getTrxName());

		String clientName = client.getName();

		MBank clientsBank = new MBank(ctx, 0, trx.getTrxName());
		clientsBank.setName(clientName + " Bank");
		clientsBank.setDescription(clientsBank.getName());
		clientsBank.setRoutingNo("DefaultRouteNo");

		clientsBank.setIsOwnBank(true);
		clientsBank.setIsActive(true);
		// Don't need to set location at this point
//		clientsBank.setC_Location_ID();

		if (!clientsBank.save())
		{
			String err = "Bank NOT inserted";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}

		// Now create accounts for this bank
		if (!createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_DEFAULT, true,
				clientsBank.getC_Bank_ID(), null)) {
			return false;
		}

		if (wantsCashBox) {
			if (!createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_CASH_BOX, false,
					clientsBank.getC_Bank_ID(), MBandaSetup.ACCOUNTVALUE_CASH_BOX)) {
				return false;
			}
		}

		if (wantsMobile && !createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_MOBILE, false,
				clientsBank.getC_Bank_ID(), MBandaSetup.ACCOUNTVALUE_MOBILE)) {
			return false;
		}

		if (wantsSavings && !createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_SAVINGS, false,
				clientsBank.getC_Bank_ID(), MBandaSetup.ACCOUNTVALUE_SAVINGS)) {
			return false;
		}

		if (!createPaymentBankAccountMappings()) {
			return false;
		}

		return true;
	}

	public boolean addDefaultCharges() {
		throw new UnsupportedOperationException("This method has not been implemented yet.");
	}

	public boolean addDefaultProductsAndServices() {
		throw new UnsupportedOperationException("This method has not been implemented yet.");
	}

	private boolean createPaymentBankAccountMappings() {
		MReference paymentBankAccountMappingReference = new Query(
				ctx,
				MReference.Table_Name,
				MReference.COLUMNNAME_AD_Reference_UU + "=?",
				trx.getTrxName()
		)
				.setParameters(MBandaSetup.REFERENCE_PAYMENT_REF_UU)
				.first();
		if (paymentBankAccountMappingReference == null) {
			log.severe("No Reference in the System for Payment Bank Account Mappings");
			trx.rollback();
			trx.close();
			return false;
		}
		MRefTable paymentBankAccountMappingsReferenceLimiting = new Query(
				ctx,
				MRefTable.Table_Name,
				MRefTable.COLUMNNAME_AD_Reference_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(paymentBankAccountMappingReference.getAD_Reference_ID())
				.first();
		if (paymentBankAccountMappingsReferenceLimiting == null) {
			log.severe("No Reference in the System for Payment Bank Account Mappings");
			trx.rollback();
			trx.close();
			return false;
		}

		List<MReference> referencesToCreatePaymentMappingsFor = new Query(
				ctx,
				MReference.Table_Name,
				paymentBankAccountMappingsReferenceLimiting.getWhereClause(),
				trx.getTrxName()
		)
				.list();
		if (referencesToCreatePaymentMappingsFor == null) {
			referencesToCreatePaymentMappingsFor = new ArrayList<MReference>();
		}
		for (MReference referenceToCreatePaymentMappingsFor : referencesToCreatePaymentMappingsFor) {
			
		}

		return true;
	}

	private boolean createAndSaveBankAccount(String clientName, String accountName, boolean isDefault,
																					 int bankId, String inTransitAccountValue) {
		MBankAccount bankAccount = new MBankAccount(ctx, 0, trx.getTrxName());
		bankAccount.setIsActive(true);
		bankAccount.setIsDefault(isDefault);
		bankAccount.setName(clientName + " " + accountName + " Account");
		bankAccount.setAD_Org_ID(orgId);
		bankAccount.setC_Bank_ID(bankId);
		bankAccount.setAccountNo(accountName + "AccountNo");
		bankAccount.setC_Currency_ID(accountSchema.getC_Currency_ID());
		bankAccount.setBankAccountType(MBankAccount.BANKACCOUNTTYPE_Cash);

		if (!bankAccount.save())
		{
			String err = accountName + " Bank Account NOT inserted";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}

		MAccount inTransitAccount = null;
		if (inTransitAccountValue != null && !inTransitAccountValue.isEmpty()) {
			MElementValue inTransitAccountElement = new Query(
					ctx,
					MElementValue.Table_Name,
					MElementValue.COLUMNNAME_Value + "=? AND " + MElementValue.COLUMNNAME_AD_Client_ID + "=?",
					trx.getTrxName()
			)
					.setParameters(inTransitAccountValue, clientId)
					.first();
			if (inTransitAccountElement == null) {
				info.append("No Account Element found for value " + inTransitAccountValue +
						". Using default In Transit value");
			} else {
				inTransitAccount = new MAccount(ctx, 0, trx.getTrxName());
				inTransitAccount.setC_AcctSchema_ID(accountSchema.getC_AcctSchema_ID());
				inTransitAccount.setAccount_ID(inTransitAccountElement.getC_ElementValue_ID());
				inTransitAccount.setValueDescription();
				if (!inTransitAccount.save()) {
					log.severe("In-Transit Account NOT inserted");
					trx.rollback();
					trx.close();
					return false;
				}
			}
		}

		return updateAccountMappingsForBankAccount(bankAccount, inTransitAccount);
	}

	private boolean updateAccountMappingsForBankAccount(MBankAccount bankAccount, MAccount inTransitAccount) {
		X_C_BankAccount_Acct accountMapping = new Query(
				ctx,
				X_C_BankAccount_Acct.Table_Name,
				X_C_BankAccount_Acct.COLUMNNAME_C_BankAccount_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(bankAccount.getC_BankAccount_ID())
				.first();
		if (accountMapping == null) {
			log.severe("No Account Mapping for Bank Account");
			trx.rollback();
			trx.close();
			return false;
		}
		if (inTransitAccount != null) {
			accountMapping.setB_InTransit_Acct(inTransitAccount.getC_ValidCombination_ID());
		}
		accountMapping.setB_Asset_Acct(accountMapping.getB_InTransit_Acct());
		if (!accountMapping.save()) {
			String err = "Account Mapping NOT updated";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}

		return true;
	}

	public MAcctSchema getAccountSchema() {
		return accountSchema;
	}

	/**
	 * 	Rollback Internal Transaction
	 */
	public void rollback() {
		try {
			trx.rollback();
			trx.close();
		} catch (Exception e) {}
	}
}
