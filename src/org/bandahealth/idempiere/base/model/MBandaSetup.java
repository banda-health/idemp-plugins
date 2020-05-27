package org.bandahealth.idempiere.base.model;

import org.compiere.impexp.ImpFormat;
import org.compiere.impexp.MImpFormat;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaDefault;
import org.compiere.model.MBank;
import org.compiere.model.MBankAccount;
import org.compiere.model.MClient;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MProductCategoryAcct;
import org.compiere.model.MRefTable;
import org.compiere.model.MReference;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_C_BankAccount_Acct;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public static final String REFERENCE_PAYMENT_REF_UU = "5943153c-cf7b-4bd1-96b7-ff36d1c0f860";
	/* The UU of the Accounting - Accounts import format */
	public static final String IMPORTFORMAT_ACCOUNTING_ACCOUNTS_UU = "7fbbb20b-8521-47e4-b0e1-31332f17958b";

	public MBandaSetup(Properties ctx, String clientName, String orgName) {
		this.ctx = ctx;
		language = Env.getAD_Language(this.ctx);

		clientId = new Query(
				this.ctx,
				MClient.Table_Name,
				MClient.COLUMNNAME_Name + "=?",
				trx.getTrxName()
		)
				.setParameters(clientName)
				.firstId();
		orgId = new Query(
				this.ctx,
				MOrg.Table_Name,
				MOrg.COLUMNNAME_Name + "=? AND " + MOrg.COLUMNNAME_AD_Client_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(orgName, clientId)
				.firstId();

		// For some reason, the client ID isn't set. Set it so entity creation doesn't error out
		Env.setContext(this.ctx, Env.AD_CLIENT_ID, clientId);

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

	private final Trx trx = Trx.get(Trx.createTrxName("Setup"), true);
	private final Properties ctx;
	private final String language;
	private StringBuffer info;

	private final int clientId;
	private final int orgId;
	private final MAcctSchema accountSchema;

	public void start() {
		trx.setDisplayName(getClass().getName()+"_createClient_BH");
		trx.start();
	}

	public boolean finish() {
		boolean success = trx.commit();
		trx.close();
		log.info("finish");
		return success;
	}

	public boolean updateDefaultAccountMapping() {
		info = new StringBuffer();

		MAcctSchemaDefault acctSchemaDefault = new Query(
				ctx,
				MAcctSchemaDefault.Table_Name,
				MAcctSchemaDefault.COLUMNNAME_AD_Client_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(clientId)
				.first();
		if (acctSchemaDefault == null) {
			log.severe("No Accounting Schema Defaults for client");
			trx.rollback();
			trx.close();
			return false;
		}

		// Make the B_Asset account match the B_InTransit account
		MAccount assetAccount = (MAccount) MTable.get(ctx, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_Asset_Acct(), trx.getTrxName());
		MAccount inTransitAccount = (MAccount) MTable.get(ctx, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_InTransit_Acct(), trx.getTrxName());
		if (assetAccount == null || inTransitAccount == null) {
			String err = "B_Asset and/or B_InTransit accounts do not exist";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}
		assetAccount.setAccount_ID(inTransitAccount.getAccount_ID());
		assetAccount.setValueDescription();
		if (!assetAccount.save()) {
			String err = "B_Asset account NOT updated";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}

		// Make the B_PaymentSelect account match the V_Liability account
		MAccount paymentSelectAccount = (MAccount) MTable.get(ctx, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_PaymentSelect_Acct(), trx.getTrxName());
		MAccount liabilityAccount = (MAccount) MTable.get(ctx, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getV_Liability_Acct(), trx.getTrxName());
		if (paymentSelectAccount == null || liabilityAccount == null) {
			String err = "B_PaymentSelect and/or V_Liability accounts do not exist";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}
		paymentSelectAccount.setAccount_ID(liabilityAccount.getAccount_ID());
		paymentSelectAccount.setValueDescription();
		if (!paymentSelectAccount.save()) {
			String err = "B_PaymentSelect account NOT updated";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}

		return true;
	}

	public boolean createBankAccounts(boolean wantsCashBox, boolean wantsMobile, boolean wantsSavings) {
		info = new StringBuffer();

		MClient client = (MClient) MTable.get(ctx, MClient.Table_ID).getPO(clientId, trx.getTrxName());

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

		info.append(Msg.translate(language, "C_Bank_ID")).append("=").append(clientsBank.getC_Bank_ID())
				.append("\n");

		// Now create accounts for this bank
		if (!createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_DEFAULT, true,
				clientsBank.getC_Bank_ID(), null)) {
			return false;
		}

		if (wantsCashBox && !createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_CASH_BOX, false,
				clientsBank.getC_Bank_ID(), MBandaSetup.ACCOUNTVALUE_CASH_BOX)) {
			return false;
		}

		if (wantsMobile && !createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_MOBILE, false,
				clientsBank.getC_Bank_ID(), MBandaSetup.ACCOUNTVALUE_MOBILE)) {
			return false;
		}

		if (wantsSavings && !createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_SAVINGS, false,
				clientsBank.getC_Bank_ID(), MBandaSetup.ACCOUNTVALUE_SAVINGS)) {
			return false;
		}

		return createPaymentBankAccountMappings();
	}

	public boolean addDefaultCharges() {
		info = new StringBuffer();

		// First, create the default charge category
		MChargeType_BH defaultCategory = new MChargeType_BH(ctx, 0, trx.getTrxName());
		defaultCategory.setName(MChargeType_BH.CHARGETYPENAME_DEFAULT_CATEGORY);
		if (!defaultCategory.save()) {
			String err = "Default Category Charge Type NOT inserted";
			log.log(Level.SEVERE, err);
			info.append(err);
			trx.rollback();
			trx.close();
			return false;
		}

		// Get all active, default charges from the system
		List<MBHChargeDefault> defaultCharges = new Query(
				ctx,
				MBHChargeDefault.Table_Name,
				"1=1",
				trx.getTrxName()
		)
				.setOnlyActiveRecords(true)
				.list();
		if (defaultCharges == null) {
			defaultCharges = new ArrayList<MBHChargeDefault>();
		}

		for (MBHChargeDefault defaultCharge : defaultCharges) {
			// Create a new charge based on this default charge
			MCharge_BH chargeToAdd = new MCharge_BH(ctx, 0, trx.getTrxName());
			chargeToAdd.setName(defaultCharge.getName());
			chargeToAdd.setDescription(defaultCharge.getDescription());
			chargeToAdd.setBH_Locked(true);
			chargeToAdd.setC_ChargeType_ID(defaultCategory.getC_ChargeType_ID());
			if (!chargeToAdd.save()) {
				String err = "Default Charge NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}

			// Create a valid combination for this account value
			MAccount chargeExpenseAccount = getOrCreateValidCombination(defaultCharge.getValue());
			if (chargeExpenseAccount == null) {
				String err = "Default Charge Valid Combination NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
			// Now get the charge's accounting mapping
			X_C_Charge_Acct chargeAcctToModify = new Query(
					ctx,
					X_C_Charge_Acct.Table_Name,
					X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + "=?",
					trx.getTrxName()
			)
					.setParameters(chargeToAdd.getC_Charge_ID())
					.first();
			if (chargeAcctToModify == null) {
				String err = "Charge Account does not exist";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
			// Point the charge to our valid combination
			chargeAcctToModify.setCh_Expense_Acct(chargeExpenseAccount.getC_ValidCombination_ID());
			if (!chargeAcctToModify.save()) {
				String err = "Charge Account NOT updated";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
		}

		return true;
	}

	public boolean createDefaultProductCategories() {
		info = new StringBuffer();

		// Get all active, default product categories from the system
		List<MBHProductCategoryDefault> defaultProductCategories = new Query(
				ctx,
				MBHProductCategoryDefault.Table_Name,
				"1=1",
				trx.getTrxName()
		)
				.setOnlyActiveRecords(true)
				.list();
		if (defaultProductCategories == null) {
			defaultProductCategories = new ArrayList<MBHProductCategoryDefault>();
		}

		for (MBHProductCategoryDefault defaultProductCategory : defaultProductCategories) {
			// Create a new product category based on this default product category
			MProductCategory_BH productCategoryToAdd = new MProductCategory_BH(ctx, 0, trx.getTrxName());
			productCategoryToAdd.setAD_Org_ID(orgId);
			productCategoryToAdd.setName(defaultProductCategory.getName());
			productCategoryToAdd.setIsActive(true);
			productCategoryToAdd.setIsDefault(false);
			productCategoryToAdd.setIsSelfService(true);
			productCategoryToAdd.setBH_Product_Category_Type(defaultProductCategory.getBH_Product_Category_Type());
			if (!productCategoryToAdd.save()) {
				String err = "Default Product Category NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}

			// Create a valid combination for this account value
			MAccount productCategoryAccount = getOrCreateValidCombination(defaultProductCategory.getValue());
			if (productCategoryAccount == null) {
				String err = "Default Product Category Valid Combination NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
			// Now get the product category's accounting mapping
			MProductCategoryAcct productCategoryAccountToModify = new Query(
					ctx,
					MProductCategoryAcct.Table_Name,
					MProductCategoryAcct.COLUMNNAME_M_Product_Category_ID + "=?",
					trx.getTrxName()
			)
					.setParameters(productCategoryToAdd.getM_Product_Category_ID())
					.first();
			if (productCategoryAccountToModify == null) {
				String err = "Product Category Account does not exist";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
			// Point the product category to our valid combination
			productCategoryAccountToModify.setP_Revenue_Acct(productCategoryAccount.getC_ValidCombination_ID());
			if (!productCategoryAccountToModify.save()) {
				String err = "Product Category Account NOT updated";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
		}

		return true;
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

		// So that we don't have to hard code these values, get the ones stored for the screen's dynamic validation
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
			MBHPaymentRef paymentRef = new MBHPaymentRef(ctx, 0, trx.getTrxName());
			paymentRef.setAD_Org_ID(orgId);
			paymentRef.setAD_Reference_ID(referenceToCreatePaymentMappingsFor.getAD_Reference_ID());
			if (!paymentRef.save()) {
				String err = "Payment Bank Account mapping NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				trx.rollback();
				trx.close();
				return false;
			}
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
			return true;
		}

		MAccount inTransitAccount = null;
		if (inTransitAccountValue != null && !inTransitAccountValue.isEmpty()) {
			inTransitAccount = getOrCreateValidCombination(inTransitAccountValue);
		}
		if (inTransitAccountValue != null && inTransitAccount == null) {
			info.append("No Account Element found for value ").append(inTransitAccountValue)
					.append(". Using default In-Transit Account value");
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

	private MAccount getOrCreateValidCombination(String accountValue) {
		MElementValue accountElement = new Query(
				ctx,
				MElementValue.Table_Name,
				MElementValue.COLUMNNAME_Value + "=? AND " + MElementValue.COLUMNNAME_AD_Client_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(accountValue, clientId)
				.first();
		if (accountElement == null) {
			return null;
		}
		// See if an account already exists for this account value
		MAccount account = new Query(
				ctx,
				MAccount.Table_Name,
				MAccount.COLUMNNAME_AD_Client_ID + "=? AND " + MAccount.COLUMNNAME_Account_ID + "=?",
				trx.getTrxName()
		)
				.setParameters(accountElement.getAD_Client_ID(), accountElement.getC_ElementValue_ID())
				.first();
		if (account != null) {
			return account;
		}
		
		account = new MAccount(ctx, 0, trx.getTrxName());
		account.setC_AcctSchema_ID(accountSchema.getC_AcctSchema_ID());
		account.setAccount_ID(accountElement.getC_ElementValue_ID());
		account.setValueDescription();
		if (!account.save()) {
			log.severe("Account NOT inserted");
			trx.rollback();
			trx.close();
			return null;
		}
		return account;
	}

	/**
	 *  Get Client
	 *  @return AD_Client_ID
	 */
	public int getAD_Client_ID()
	{
		return clientId;
	}
	/**
	 * 	Get AD_Org_ID
	 *	@return AD_Org_ID
	 */
	public int getAD_Org_ID()
	{
		return orgId;
	}

	/**
	 * Get AccountSchema
	 * @return AccountSchema
	 */
	public MAcctSchema getAccountSchema() {
		return accountSchema;
	}

	/**
	 * 	Get Info
	 *	@return Info
	 */
	public String getInfo()
	{
		return info.toString();
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
