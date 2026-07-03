package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.compiere.model.I_C_Location;
import org.compiere.model.I_C_ValidCombination;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctProcessor;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaDefault;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MBPGroup;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MBank;
import org.compiere.model.MBankAccount;
import org.compiere.model.MClient;
import org.compiere.model.MConversionType;
import org.compiere.model.MCostElement;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDiscountSchemaLine;
import org.compiere.model.MDocType;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MPInstance;
import org.compiere.model.MPeriod;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProcess;
import org.compiere.model.MProductCategoryAcct;
import org.compiere.model.MRefList;
import org.compiere.model.MRefTable;
import org.compiere.model.MReference;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.MSchedule;
import org.compiere.model.MTable;
import org.compiere.model.MUserRoles;
import org.compiere.model.MWarehouse;
import org.compiere.model.MYear;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Document_Action_Access;
import org.compiere.model.X_C_BP_Group_Acct;
import org.compiere.model.X_C_BankAccount_Acct;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.model.X_M_AttributeSetExclude;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.CLogger;
import org.compiere.util.CacheMgt;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Initial setup of a client, but with the additional things needed in Banda Go
 */
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
	/* The shared daily schedule every tenant's accounting processor runs on (GO-3636/GO-3654) */
	public static final int SCHEDULE_ACCOUNTING_PROCESSOR_ID = 200000;
	/* The shared "15 Days" schedule every tenant's request processor runs on (GO-3636/GO-3654) */
	public static final int SCHEDULE_REQUEST_PROCESSOR_ID = 1000000;
	/* The overnight load-trough windows the processors' first run is staggered into, in minutes after midnight
	 * (accounting 00:00-01:59, request 02:00-03:44 -- must match the fleet-wide spread from GO-3636) */
	public static final int ACCT_PROCESSOR_TROUGH_START_MINUTES = 0;
	public static final int ACCT_PROCESSOR_TROUGH_WINDOW_MINUTES = 120;
	public static final int REQUEST_PROCESSOR_TROUGH_START_MINUTES = 120;
	public static final int REQUEST_PROCESSOR_TROUGH_WINDOW_MINUTES = 105;
	/**
	 * Admin = A
	 */
	public static final String DB_USERTYPE_Admin = "A";
	/**
	 * User = U
	 */
	public static final String DB_USERTYPE_User = "U";
	private final Trx transaction = Trx.get(Trx.createTrxName("Setup"), true);
	private final Properties context;
	private final String language;
	private final MClient client;
	private final MOrg organization;
	private final MAcctSchema accountSchema;
	private final String BANK_DEFAULT_ROUTING_NUMBER = "DefaultRouteNo";
	private final String SUFFIX_TRANSACTION_NAME = "_createClient_BH";
	private final String SUFFIX_BANK_NAME = " Bank";
	private final String SUFFIX_BANK_ACCOUNT_NAME = " Account";
	private final String SUFFIX_BANK_ACCOUNT_NUMBER = "AccountNo";
	public static final String DEFAULT_IDEMPIERE_ENTITY_NAME = "Standard";
	public static final String PREFIX_OTC_BUSINESS_PARTNER = "OTC - ";
	protected CLogger log = CLogger.getCLogger(getClass());
	private StringBuffer info;

	public MBandaSetup(Properties ctx, MClient client, MOrg organization) {
		if (ctx == null) {
			String errorMessage = "Parameter 'ctx' is required";
			log.log(Level.SEVERE, errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
		if (client == null) {
			String errorMessage = "Parameter 'client' is required";
			log.log(Level.SEVERE, errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

		this.context = ctx;
		language = Env.getAD_Language(this.context);
		this.client = client;
		this.organization = organization;
		info = new StringBuffer();

		accountSchema = new Query(this.context, MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_AD_Client_ID + "=?",
				getTransactionName()).setParameters(getAD_Client_ID()).first();
	}

	public static String getRoleName(String clientName, String roleSuffix) {
		if (clientName == null) {
			throw new IllegalArgumentException("Parameter 'clientName' is required");
		}
		if (roleSuffix == null) {
			throw new IllegalArgumentException("Parameter 'roleSuffix' is required");
		}
		return clientName + " " + roleSuffix;
	}

	public void start() {
		transaction.setDisplayName(getClass().getName() + SUFFIX_TRANSACTION_NAME);
		transaction.start();
	}

	public boolean finish() {
		boolean success = transaction.commit();
		transaction.close();
		log.info("finish");
		return success;
	}

	/**
	 * This takes care of creating our custom sequences, such as for the patient id
	 *
	 * @return Whether the creation was successful or not
	 */
	public boolean createSequences() {
		MSequence_BH.createTableSequence(context,
				MSequence_BH.GENERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITHOUT_PREFIX, getTransactionName(), false);
		return true;
	}

	/**
	 * This method updates the accounting schema costing method and level, then
	 * ensures a costing element is created that matches the costing method
	 *
	 * @return Whether creation was successful or not
	 */
	public boolean updateAccountingSchemaCosting() {
		accountSchema.setCostingMethod(MAcctSchema.COSTINGMETHOD_LastPOPrice);
		accountSchema.setCostingLevel(MAcctSchema.COSTINGLEVEL_BatchLot);
		if (!accountSchema.save()) {
			log.severe("Accounting Schema method and level not updated");
			transaction.rollback();
			transaction.close();
			return false;
		}

		MCostElement costElement = new Query(context, MCostElement.Table_Name,
				MCostElement.COLUMNNAME_Name + "=? AND " + MCostElement.COLUMNNAME_CostElementType + " =? AND "
						+ MCostElement.COLUMNNAME_CostingMethod + " =?",
				getTransactionName())
				.setParameters("Last PO Price", MCostElement.COSTELEMENTTYPE_Material,
						MCostElement.COSTINGMETHOD_LastPOPrice)
				.setClient_ID().first();
		if (costElement == null) {
			costElement = new MCostElement(context, 0, getTransactionName());
			costElement.setName("Last PO Price");
			costElement.setCostElementType(MCostElement.COSTELEMENTTYPE_Material);
			costElement.setCostingMethod(MCostElement.COSTINGMETHOD_LastPOPrice);
			return costElement.save();
		}
		return true;
	}

	public boolean updateDefaultAccountMapping() {
		MAcctSchemaDefault acctSchemaDefault = new Query(context, MAcctSchemaDefault.Table_Name,
				MAcctSchemaDefault.COLUMNNAME_AD_Client_ID + "=?", getTransactionName())
				.setParameters(getAD_Client_ID()).first();
		if (acctSchemaDefault == null) {
			log.severe("No Accounting Schema Defaults for client");
			transaction.rollback();
			transaction.close();
			return false;
		}

		// In iDempiere, accounts are mapped to many different things, such as bank
		// accounts and charges. The default account mappings generated map different
		// accounts to the Bank Asset account (B_Asset) and the Bank In-Transit account
		// (B_InTransit). Based on a recommendation from Chuck, we simplify this mapping
		// and choose to map these accounts to the same default account because we don't
		// ever upload bank statements, which is the default way iDempiere transfers
		// value from B_InTransit to B_Asset. So, we need to make the B_Asset account
		// match the B_InTransit account.
		MAccount assetAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_Asset_Acct(), getTransactionName());
		MAccount inTransitAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_InTransit_Acct(), getTransactionName());
		if (assetAccount == null || inTransitAccount == null) {
			String errorMessage = "B_Asset and/or B_InTransit accounts do not exist";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}
		assetAccount.setAccount_ID(inTransitAccount.getAccount_ID());
		assetAccount.setValueDescription();
		if (!assetAccount.save()) {
			String errorMessage = "B_Asset account NOT updated";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}

		// The default account mappings generated map different accounts to the Vendor
		// Liability account (V_Liability) and the Bank Payment Select account
		// (B_PaymentSelect). Based on a recommendation from Chuck, we simplify this
		// mapping and choose to map these accounts to the same default account. So, we
		// need to make the B_PaymentSelect account match the V_Liability account.
		MAccount paymentSelectAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_PaymentSelect_Acct(), getTransactionName());
		MAccount liabilityAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getV_Liability_Acct(), getTransactionName());
		if (paymentSelectAccount == null || liabilityAccount == null) {
			String errorMessage = "B_PaymentSelect and/or V_Liability accounts do not exist";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}
		paymentSelectAccount.setAccount_ID(liabilityAccount.getAccount_ID());
		paymentSelectAccount.setValueDescription();
		if (!paymentSelectAccount.save()) {
			String errorMessage = "B_PaymentSelect account NOT updated";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}

		return true;
	}

	/**
	 * Create bank accounts for the client
	 *
	 * @param wantsCashBox
	 * @param wantsMobile
	 * @param wantsSavings
	 * @return
	 */
	public boolean createBankAccounts(boolean wantsCashBox, boolean wantsMobile, boolean wantsSavings) {
		String clientName = client.getName();

		MBank clientsBank = new MBank(context, 0, getTransactionName());
		clientsBank.setName(clientName + SUFFIX_BANK_NAME);
		clientsBank.setDescription(clientsBank.getName());
		clientsBank.setRoutingNo(BANK_DEFAULT_ROUTING_NUMBER);

		clientsBank.setIsOwnBank(true);
		clientsBank.setIsActive(true);
		// Don't need to set location at this point
		// clientsBank.setC_Location_ID();

		if (!clientsBank.save()) {
			String errorMessage = "Bank NOT inserted";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}

		info.append(Msg.translate(language, "C_Bank_ID")).append("=").append(clientsBank.getC_Bank_ID()).append("\n");

		// Now create accounts for this bank
		if (!createAndSaveBankAccount(clientName, MBandaSetup.ACCOUNTNAME_DEFAULT, true, clientsBank.getC_Bank_ID(),
				null)) {
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

	/**
	 * Add the default charge types configured in the config client.
	 *
	 * @return A map of default charge type IDs to the charge type that was added
	 * for the client
	 */
	private Map<Integer, MChargeType_BH> addDefaultChargeTypes() {
		PO.setCrossTenantSafe();
		List<MChargeType_BH> defaultChargeTypes = new Query(context, MChargeType_BH.Table_Name,
				MChargeType_BH.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
				.setParameters(MClient_BH.CLIENTID_CONFIG).list();
		PO.clearCrossTenantSafe();

		Map<Integer, MChargeType_BH> defaultChargeTypeMap = new HashMap<>();
		for (MChargeType_BH defaultChargeType : defaultChargeTypes) {
			MChargeType_BH chargeType = new MChargeType_BH(context, 0, getTransactionName());
			chargeType.setName(defaultChargeType.getName());
			chargeType.setDescription(defaultChargeType.getDescription());
			chargeType.setValue(defaultChargeType.getValue());
			if (!chargeType.save()) {
				String errorMessage = "Default Charge Type NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return null;
			}
			defaultChargeTypeMap.put(defaultChargeType.get_ID(), chargeType);
		}

		return defaultChargeTypeMap;
	}

	/**
	 * Add the charges that should be included on a new client by default (pulled
	 * from the default charges table
	 *
	 * @return Whether the charges were added successfully or not
	 */
	public boolean addDefaultCharges() {
		// First, create the default charge types
		Map<Integer, MChargeType_BH> defaultChargeTypeMap = addDefaultChargeTypes();
		// Get collection of account_element_values mapped on the default charges
		Map<Integer, MElementValue> elementValuesMap = getAllElementValues();

		if (defaultChargeTypeMap == null || defaultChargeTypeMap.isEmpty()) {
			return false;
		}
		// Get all active, default charges from the default client
		PO.setCrossTenantSafe();
		List<MCharge_BH> defaultCharges = new Query(context, MCharge_BH.Table_Name,
				MCharge_BH.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
				.setParameters(MClient_BH.CLIENTID_CONFIG).list();
		PO.clearCrossTenantSafe();

		for (MCharge_BH defaultCharge : defaultCharges) {
			// Create a new charge for new client based on this default charge
			MCharge_BH charge = new MCharge_BH(context, 0, getTransactionName());
			charge.setName(defaultCharge.getName());
			charge.setDescription(defaultCharge.getDescription());
			charge.setC_ChargeType_ID(defaultChargeTypeMap.get(defaultCharge.getC_ChargeType_ID()).get_ID());
			charge.setBH_Locked(defaultCharge.isBH_Locked());
			charge.setBH_SubType(defaultCharge.getBH_SubType());
			if (!charge.save()) {
				String errorMessage = "Default Charge NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}

			// Get the account associated with this charge
			PO.setCrossTenantSafe();
			X_C_Charge_Acct defaultChargeChargeAccount =
					new Query(this.context, X_C_Charge_Acct.Table_Name, X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + "=?",
							this.getTransactionName()).setParameters(defaultCharge.getC_Charge_ID()).first();

			// Create a valid combination for this account value
			MAccount chargeExpenseAccount = getOrCreateValidCombination(
					elementValuesMap.get(defaultChargeChargeAccount.getCh_Expense_A().getAccount_ID())
							.getValue());
			PO.clearCrossTenantSafe();

			if (chargeExpenseAccount == null) {
				String errorMessage = "Default Charge Valid Combination NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Now get the charge's accounting mapping
			X_C_Charge_Acct chargeAccountToModify = new Query(context, X_C_Charge_Acct.Table_Name,
					X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + "=?", getTransactionName())
					.setParameters(charge.getC_Charge_ID()).first();
			if (chargeAccountToModify == null) {
				String errorMessage = "Charge Account does not exist";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Point the charge to our valid combination
			chargeAccountToModify.setCh_Expense_Acct(chargeExpenseAccount.getC_ValidCombination_ID());
			if (!chargeAccountToModify.save()) {
				String errorMessage = "Charge Account NOT updated";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
		}
		return true;
	}

	/**
	 * Add insurance & donation payers for this client
	 */
	private boolean addPayerInformationFields(Map<Integer, Integer> clientPayerIdsByDefaultPayerId) {
		Map<Integer, MBHPayerInfoFldVal> infoValues = getDefaultPayerInfoFieldValuesMap();

		PO.setCrossTenantSafe();
		List<MBHPayerInfoFld> defaultPayerInfoFieldList = new Query(context, MBHPayerInfoFld.Table_Name,
				MBHPayerInfoFld.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
				.setParameters(MClient_BH.CLIENTID_CONFIG).list();
		PO.clearCrossTenantSafe();

		// Filter out payer information for BPs we didn't save
		defaultPayerInfoFieldList = defaultPayerInfoFieldList.stream().filter(
				defaultPayerInformationField -> clientPayerIdsByDefaultPayerId
						.containsKey(defaultPayerInformationField.getBH_Payer_ID())).collect(Collectors.toList());

		for (MBHPayerInfoFld defaultPayerInfoField : defaultPayerInfoFieldList) {
			MBHPayerInfoFld payerInfoField = new MBHPayerInfoFld(context, 0, getTransactionName());
			payerInfoField.setBH_PayerInfoFieldDataType(defaultPayerInfoField.getBH_PayerInfoFieldDataType());
			payerInfoField.setBH_FillFromPatient(defaultPayerInfoField.isBH_FillFromPatient());
			payerInfoField.setBH_Payer_ID(clientPayerIdsByDefaultPayerId.get(defaultPayerInfoField.getBH_Payer_ID()));
			payerInfoField.setName(defaultPayerInfoField.getName());
			payerInfoField.setLine(defaultPayerInfoField.getLine());
			if (!payerInfoField.save()) {
				String errorMessage = "Payer Info Field NOT saved";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}

			List<MBHPayerInfoFldVal> defaultPayerInformationFieldValuesForDefaultPayerInformationField =
					infoValues.values().stream().filter(
							payerInformationFieldValue -> payerInformationFieldValue.getBH_Payer_Info_Fld_ID() ==
									defaultPayerInfoField.getBH_Payer_Info_Fld_ID()).collect(Collectors.toList());

			// We need to get all payer info values mapped for this charge info from the map
			for (MBHPayerInfoFldVal defaultPayerInformationFieldValue :
					defaultPayerInformationFieldValuesForDefaultPayerInformationField) {
				MBHPayerInfoFldVal chargeInfoValue = new MBHPayerInfoFldVal(context, 0, getTransactionName());
				chargeInfoValue.setName(defaultPayerInformationFieldValue.getName());
				chargeInfoValue.setBH_Payer_Info_Fld_ID(payerInfoField.getBH_Payer_Info_Fld_ID());
				chargeInfoValue.setLine(defaultPayerInformationFieldValue.getLine());
				if (!chargeInfoValue.save()) {
					String errorMessage = "Payer Info Field Value NOT saved";
					log.log(Level.SEVERE, errorMessage);
					info.append(errorMessage);
					transaction.rollback();
					transaction.close();
					return false;

				}
			}
		}
		return true;
	}

	/**
	 * This creates the default product categories for a client
	 *
	 * @return
	 */
	public boolean createDefaultProductCategories() {
		// Get all active, default product categories from the system
		List<MBHProductCategoryDefault> defaultProductCategories = new Query(context,
				MBHProductCategoryDefault.Table_Name, null, getTransactionName()).setOnlyActiveRecords(true).list();

		for (MBHProductCategoryDefault defaultProductCategory : defaultProductCategories) {
			// Create a new product category based on this default product category
			MProductCategory_BH productCategoryToAdd = new MProductCategory_BH(context, 0, getTransactionName());
			productCategoryToAdd.setAD_Org_ID(getAD_Org_ID());
			productCategoryToAdd.setName(defaultProductCategory.getName());
			productCategoryToAdd.setIsActive(true);
			productCategoryToAdd.setIsDefault(false);
			productCategoryToAdd.setIsSelfService(true);
			productCategoryToAdd.setBH_Product_Category_Type(defaultProductCategory.getBH_Product_Category_Type());
			if (!productCategoryToAdd.save()) {
				String errorMessage = "Default Product Category NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}

			// Create a valid combination for this account value
			MAccount productCategoryAccount = getOrCreateValidCombination(defaultProductCategory.getValue());
			if (productCategoryAccount == null) {
				String errorMessage = "Default Product Category Valid Combination NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Now get the product category's accounting mapping
			MProductCategoryAcct productCategoryAccountToModify = new Query(context, MProductCategoryAcct.Table_Name,
					MProductCategoryAcct.COLUMNNAME_M_Product_Category_ID + "=?", getTransactionName())
					.setParameters(productCategoryToAdd.getM_Product_Category_ID()).first();
			if (productCategoryAccountToModify == null) {
				String errorMessage = "Product Category Account does not exist";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Point the product category to our valid combination
			productCategoryAccountToModify.setP_Revenue_Acct(productCategoryAccount.getC_ValidCombination_ID());
			if (!productCategoryAccountToModify.save()) {
				String errorMessage = "Product Category Account NOT updated";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
		}

		return true;
	}

	/**
	 * Perform any resets on the user role that was automatically created by
	 * iDempiere
	 *
	 * @return Whether the user role was successfully reset or not
	 */
	public boolean resetUserRole() {
		MRefList userRoleReferenceList = new Query(this.context, MRefList.Table_Name,
				MRefList.Table_Name + "." + MRefList.COLUMNNAME_Value + "=? AND" + " " + MReference_BH.Table_Name + "."
						+ MReference_BH.COLUMNNAME_AD_Reference_UU + "=?",
				getTransactionName())
				.addJoinClause(" JOIN " + MReference_BH.Table_Name + " ON " + MReference_BH.Table_Name + "."
						+ MReference_BH.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "."
						+ MRefList.COLUMNNAME_AD_Reference_ID)
				.setParameters(DB_USERTYPE_User, MReference_BH.USER_TYPE_AD_REFERENCE_UU).first();

		// If the admin reference list doesn't exist, there's a big problem...
		if (userRoleReferenceList == null) {
			log.log(Level.SEVERE, "User role suffix (a reference list) not found in system");
			return false;
		}

		MRole userRole = new Query(this.context, MRole.Table_Name, MRole.COLUMNNAME_Name + "=?", getTransactionName())
				.setParameters(getRoleName(client.getName(), userRoleReferenceList.getName())).setClient_ID().first();
		if (userRole == null) {
			log.log(Level.SEVERE, "User role not defined for client");
			return false;
		}
		userRole.setIsManual(true);
		return userRole.save();
	}

	/**
	 * The roles for admin and user are created by default - add roles for
	 * additional ones in the system, then handle the associated access for all
	 * roles.
	 *
	 * @return Whether the creation was successful
	 */
	public boolean initializeRoles(List<MUser_BH> usersToAddRolesTo) {
		if (usersToAddRolesTo == null) {
			log.log(Level.SEVERE, "Parameter 'usersToAddRolesTo' is required");
			return false;
		}

		MReference userType = new Query(this.context, MReference_BH.Table_Name,
				MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", getTransactionName())
				.setParameters(MReference_BH.USER_TYPE_AD_REFERENCE_UU).first();
		if (userType == null) {
			log.log(Level.SEVERE, "User type reference not defined");
			return false;
		}

		List<MRefList> userTypeValues = new Query(this.context, MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?", getTransactionName())
				.setParameters(userType.getAD_Reference_ID()).setOnlyActiveRecords(true).list();

		if (!createAdditionalRoles(userTypeValues, usersToAddRolesTo)) {
			log.log(Level.SEVERE, "Error creating additional roles");
			return false;
		}

		// Ensure all the roles are present from this point forward
		// Get the roles for this client
		List<MRole> clientRoles = new Query(context, MRole.Table_Name, MRole.COLUMNNAME_AD_Client_ID + "=?",
				getTransactionName()).setParameters(getAD_Client_ID()).list();
		// We don't want to do anything to the admin role, so filter it out (it should
		// be handled by iDempiere)
		Map<MRefList, MRole> rolesExceptAdminToConfigureByDBUserType = userTypeValues.stream()
				.filter(userTypeValue -> !userTypeValue.getValue().equals(DB_USERTYPE_Admin))
				.collect(HashMap::new, (rolesToConfigureByDBUserTypeTemp,
								userTypeValue) -> rolesToConfigureByDBUserTypeTemp.put(userTypeValue, clientRoles.stream()
								.filter(clientRole -> clientRole.getName()
										.equals(MBandaSetup.getRoleName(client.getName(), userTypeValue.getName())))
								.findFirst().orElse(null)),
						HashMap::putAll);

		// Ensure all the roles are present
		AtomicBoolean areAllRolesPresent = new AtomicBoolean(true);
		rolesExceptAdminToConfigureByDBUserType.forEach((key, value) -> {
			if (value == null) {
				String errorMessage = key + " role does not exist";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				areAllRolesPresent.set(false);
			}
		});
		if (!areAllRolesPresent.get()) {
			transaction.rollback();
			transaction.close();
			return false;
		}

		return updateRoles(rolesExceptAdminToConfigureByDBUserType);
	}

	/**
	 * This method is meant to be the post-creation version of #{initializeRoles}.
	 * It handles updating roles and everything associated with them for clients
	 * that have already been created.
	 *
	 * @param rolesToConfigureByDBUserType The roles that should be configured.
	 * @return Whether the update was successful
	 */
	public boolean updateRoles(Map<MRefList, MRole> rolesToConfigureByDBUserType) {
		if (rolesToConfigureByDBUserType == null) {
			log.log(Level.SEVERE, "Parameter 'rolesToConfigureByDBUserType' is required");
			return false;
		}

		if (!handleDefaultIncludedRoles(rolesToConfigureByDBUserType)) {
			log.log(Level.SEVERE, "Error adding default included roles");
			return false;
		}

		if (!handleDocumentActionAccess(rolesToConfigureByDBUserType)) {
			log.log(Level.SEVERE, "Error handling default document action access exclusions");
			return false;
		}

		return true;
	}

	/**
	 * Handle updating document action access based on configured rules, if any.
	 *
	 * @return Whether the document action access exclusions were successfully
	 * applied
	 */
	private boolean handleDocumentActionAccess(Map<MRefList, MRole> rolesToConfigureByDBUserType) {
		// Pull the document action access exclusion values
		List<MBHDefaultDocActionAccess> defaultDocActionAccess = new Query(context,
				MBHDefaultDocActionAccess.Table_Name, null, getTransactionName()).setOnlyActiveRecords(true).list();

		// We need to get a map of the default doc action exclusion IDs (which are for
		// System) and map them to the ones
		// assigned to this client
		PO.setCrossTenantSafe(); // we need to do a cross-tenant query here, so enable that
		List<MDocType> docTypesForSystemAndClient = new Query(context, MDocType.Table_Name,
				MDocType.COLUMNNAME_AD_Client_ID + " IN (?,?)", getTransactionName())
				.setParameters(MClient_BH.CLIENTID_SYSTEM, getAD_Client_ID()).list();
		Map<Integer, Integer> clientDocTypeIdsBySystemDocTypeIds = docTypesForSystemAndClient.stream()
				.filter(docType -> docType.getAD_Client_ID() == 0)
				.collect(Collectors.toMap(MDocType::getC_DocType_ID,
						systemDocType -> docTypesForSystemAndClient.stream()
								.filter(docType -> docType.getAD_Client_ID() != 0
										&& docType.getName().equals(systemDocType.getName()))
								.findFirst().map(MDocType::getC_DocType_ID).orElse(0)));
		PO.clearCrossTenantSafe(); // disable what was done previously

		// Get all access for the roles we'll configure
		List<X_AD_Document_Action_Access> currentAccessForRolesToConfigure = new Query(this.context,
				X_AD_Document_Action_Access.Table_Name,
				X_AD_Document_Action_Access.COLUMNNAME_AD_Role_ID + " IN ("
						+ rolesToConfigureByDBUserType.values().stream()
						.map(roleToConfigure -> Integer.toString(roleToConfigure.getAD_Role_ID()))
						.collect(Collectors.joining(","))
						+ ")",
				getTransactionName()).list();
		Map<Integer, List<X_AD_Document_Action_Access>> currentAccessByRole = currentAccessForRolesToConfigure.stream()
				.collect(Collectors.groupingBy(X_AD_Document_Action_Access::getAD_Role_ID));

		AtomicBoolean didSuccessfullyUpdateAllDocumentAccess = new AtomicBoolean(true);
		rolesToConfigureByDBUserType.forEach((userType, role) -> {
			List<MBHDefaultDocActionAccess> specifiedAccessForThisRole = defaultDocActionAccess.stream()
					.filter(documentActionAccess -> documentActionAccess.getDB_UserType().equals(userType.getValue()))
					.collect(Collectors.toList());

			// Get the document access action that has been saved for this role
			List<X_AD_Document_Action_Access> currentAccessForThisRole = currentAccessByRole.containsKey(
					role.getAD_Role_ID()) ? currentAccessByRole.get(role.getAD_Role_ID()) : new ArrayList<>();

			// Remove the document action access that is currently assigned, but wasn't
			// specified to be assigned
			currentAccessForThisRole.stream()
					.filter(currentAccess -> specifiedAccessForThisRole.stream().noneMatch(
							specifiedAccess -> currentAccess.getAD_Ref_List_ID() == specifiedAccess.getAD_Ref_List_ID()
									&& currentAccess.getC_DocType_ID() == clientDocTypeIdsBySystemDocTypeIds
									.get(specifiedAccess.getC_DocType_ID())))
					.forEach(accessToRemove -> {
						if (!accessToRemove.delete(true)) {
							String errorMessage = "Could not remove document action access for Role, DocType, and RefList: "
									+ role.getAD_Role_ID() + ", " + accessToRemove.getC_DocType_ID() + ", "
									+ accessToRemove.getAD_Ref_List_ID();
							log.log(Level.SEVERE, errorMessage);
							info.append(errorMessage);
							didSuccessfullyUpdateAllDocumentAccess.set(false);
						}
					});

			// Add document access that isn't currently assigned, but was specified to be
			// assigned
			specifiedAccessForThisRole.stream().filter(specifiedAccess -> currentAccessForThisRole.stream()
							.noneMatch(currentAccess -> currentAccess.getAD_Ref_List_ID() == specifiedAccess.getAD_Ref_List_ID()
									&& currentAccess.getC_DocType_ID() == clientDocTypeIdsBySystemDocTypeIds
									.get(specifiedAccess.getC_DocType_ID())))
					.forEach(accessToAdd -> {
						X_AD_Document_Action_Access clientAccess = new X_AD_Document_Action_Access(context, 0,
								getTransactionName());
						clientAccess
								.setC_DocType_ID(clientDocTypeIdsBySystemDocTypeIds.get(accessToAdd.getC_DocType_ID()));
						clientAccess.setAD_Ref_List_ID(accessToAdd.getAD_Ref_List_ID());
						clientAccess.setAD_Role_ID(role.getAD_Role_ID());

						if (!clientAccess.save()) {
							String errorMessage = "Could not add document action access for Role, DocType, and RefList: "
									+ role.getAD_Role_ID() + ", " + clientAccess.getC_DocType_ID() + ", "
									+ clientAccess.getAD_Ref_List_ID();
							log.log(Level.SEVERE, errorMessage);
							info.append(errorMessage);
							didSuccessfullyUpdateAllDocumentAccess.set(false);
						}
					});
		});

		return didSuccessfullyUpdateAllDocumentAccess.get();
	}

	/**
	 * The roles for admin and user are created by default - add ones for additional
	 * roles defined in the DB.
	 *
	 * @return Whether the creation was successful
	 */
	private boolean createAdditionalRoles(List<MRefList> userTypeSuffixes, List<MUser_BH> usersToAddRolesTo) {
		// Filter out the roles the system adds
		userTypeSuffixes = userTypeSuffixes.stream()
				.filter(userTypeSuffix -> !userTypeSuffix.getValue().equals(DB_USERTYPE_User)
						&& !userTypeSuffix.getValue().equals(DB_USERTYPE_Admin))
				.collect(Collectors.toList());
		AtomicBoolean didSuccessfullyAddedAllRoles = new AtomicBoolean(true);
		List<MOrg> organizationsToGrantToRole = Collections.singletonList(organization);
		// Add the new roles
		userTypeSuffixes.forEach(userTypeSuffix -> {
			String suffix = userTypeSuffix.getName();
			String name = MBandaSetup.getRoleName(client.getName(), suffix);
			if (!createRole(name, usersToAddRolesTo, organizationsToGrantToRole)) {
				didSuccessfullyAddedAllRoles.set(false);
			}
		});
		return didSuccessfullyAddedAllRoles.get();
	}

	/**
	 * Create the specified role and assign it to users and make it available to
	 * organizations.
	 *
	 * @param roleName                   The name of the role to create
	 * @param usersToAddRoleTo           The list of users to add this new role to
	 * @param organizationsToGrantToRole The organizations to grant this role access
	 *                                   to
	 * @return Whether role creation was successful
	 */
	public boolean createRole(String roleName, List<MUser_BH> usersToAddRoleTo, List<MOrg> organizationsToGrantToRole) {
		if (roleName == null || roleName.isEmpty()) {
			log.log(Level.SEVERE, "Parameter 'roleName' is required");
			return false;
		}
		if (usersToAddRoleTo == null) {
			log.log(Level.SEVERE, "Parameter 'usersToAddRoleTo' is required");
			return false;
		}

		if (organizationsToGrantToRole == null) {
			log.log(Level.SEVERE, "Parameter 'organizationsToGrantToRole' is required");
			return false;
		}

		MRole role = new MRole(context, 0, getTransactionName());
		role.setName(roleName);
		role.setIsAccessAdvanced(false);
		// Set manual so that access isn't automatically updated - access updates will
		// be handled via the master roles
		role.setIsManual(true);
		if (!role.save()) {
			String errorMessage = roleName + " Role NOT inserted";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			return false;
		}
		// OrgAccess x,y
		organizationsToGrantToRole.forEach(organizationToGrantToRole -> {
			MRoleOrgAccess userOrgAccess = new MRoleOrgAccess(role, organizationToGrantToRole.getAD_Org_ID());
			if (!userOrgAccess.save()) {
				log.log(Level.SEVERE, roleName + " Role_OrgAccess NOT created");
			}
		});
		// Update the appropriate users to have access to this new role
		usersToAddRoleTo.forEach(user -> {
			MUserRoles userRole = new MUserRoles(context, user.getAD_User_ID(), role.getAD_Role_ID(),
					getTransactionName());
			userRole.saveEx();
		});
		return true;
	}

	/**
	 * The roles created for a client need to have the Banda Health master roles
	 * included. Add the ones configured in the system to the created roles.
	 *
	 * @return Whether the addition was successful
	 */
	private boolean handleDefaultIncludedRoles(Map<MRefList, MRole> rolesToConfigureByDBUserType) {
		// Pull the default role IDs to include
		List<MBHDefaultIncludedRole> defaultIncludedRoles = new Query(context, MBHDefaultIncludedRole.Table_Name, null,
				getTransactionName()).setOnlyActiveRecords(true).list();
		int sequencerIncrement = 10;
		Map<Integer, Integer> roleSequencers = rolesToConfigureByDBUserType.values().stream()
				.collect(Collectors.toMap(MRole::getAD_Role_ID, v -> sequencerIncrement));

		// Get the inclusions already configured for these roles
		List<MRoleIncluded> currentIncludedRolesForRolesToConfigure = new Query(context, MRoleIncluded.Table_Name,
				MRoleIncluded.COLUMNNAME_AD_Role_ID + " IN ("
						+ rolesToConfigureByDBUserType.values().stream()
						.map(role -> Integer.toString(role.getAD_Role_ID())).collect(Collectors.joining(","))
						+ ")",
				getTransactionName()).list();
		Map<Integer, List<MRoleIncluded>> currentIncludedRolesByRoleId = currentIncludedRolesForRolesToConfigure
				.stream().collect(Collectors.groupingBy(MRoleIncluded::getAD_Role_ID));

		AtomicBoolean didSuccessfullyUpdateAllIncludedRoles = new AtomicBoolean(true);
		rolesToConfigureByDBUserType.forEach((referenceList, roleToConfigure) -> {
			// Filter the default included roles to match this role
			List<MBHDefaultIncludedRole> defaultIncludedRolesForRole = defaultIncludedRoles.stream().filter(
							defaultIncludedRole -> defaultIncludedRole.getDB_UserType().equals(referenceList.getValue()))
					.collect(Collectors.toList());
			List<MRoleIncluded> currentIncludedRolesForThisRole = currentIncludedRolesByRoleId.containsKey(
					roleToConfigure.getAD_Role_ID()) ? currentIncludedRolesByRoleId.get(roleToConfigure.getAD_Role_ID())
					: new ArrayList<>();

			// For any roles that are meant to be assigned but aren't, add them
			// Filter out roles that are already assigned
			defaultIncludedRolesForRole.stream()
					.filter(defaultIncludedRole -> currentIncludedRolesForThisRole.stream()
							.noneMatch(currentIncludedRole -> currentIncludedRole
									.getIncluded_Role_ID() == defaultIncludedRole.getIncluded_Role_ID()))
					.forEach(includedRoleToAdd -> {
						MRoleIncluded roleIncluded = new MRoleIncluded(context, 0, getTransactionName());
						roleIncluded.setIncluded_Role_ID(includedRoleToAdd.getIncluded_Role_ID());
						roleIncluded.setAD_Role_ID(roleToConfigure.getAD_Role_ID());
						int sequencerToUse = roleSequencers.get(roleToConfigure.getAD_Role_ID());
						roleIncluded.setSeqNo(sequencerToUse);
						roleSequencers.put(roleToConfigure.getAD_Role_ID(), sequencerToUse + sequencerIncrement);
						roleIncluded.saveEx();
					});

			// For any roles that are assigned but shouldn't be, remove them
			currentIncludedRolesForThisRole.stream()
					.filter(currentIncludedRole -> defaultIncludedRolesForRole.stream()
							.noneMatch(defaultIncludedRole -> currentIncludedRole
									.getIncluded_Role_ID() == defaultIncludedRole.getIncluded_Role_ID()))
					.forEach(includedRoleToRemove -> {
						if (!includedRoleToRemove.delete(true)) {
							log.severe("Could not remove included role " + includedRoleToRemove.getIncluded_Role_ID());
							didSuccessfullyUpdateAllIncludedRoles.set(false);
						}
					});
		});

		if (!didSuccessfullyUpdateAllIncludedRoles.get()) {
			transaction.rollback();
			transaction.close();
			return false;
		}

		return true;
	}

	public boolean addDefaultProductsAndServices() {
		throw new UnsupportedOperationException("This method has not been implemented yet.");
	}

	/**
	 * Create payment bank account mappings for the client
	 *
	 * @return
	 */
	private boolean createPaymentBankAccountMappings() {
		MReference paymentBankAccountMappingReference = new Query(context, MReference.Table_Name,
				MReference.COLUMNNAME_AD_Reference_UU + "=?", getTransactionName())
				.setParameters(MBandaSetup.REFERENCE_PAYMENT_REF_UU).first();
		if (paymentBankAccountMappingReference == null) {
			log.severe("No Reference in the System for Payment Bank Account Mappings");
			transaction.rollback();
			transaction.close();
			return false;
		}
		MRefTable paymentBankAccountMappingsReferenceLimiting = new Query(context, MRefTable.Table_Name,
				MRefTable.COLUMNNAME_AD_Reference_ID + "=?", getTransactionName())
				.setParameters(paymentBankAccountMappingReference.getAD_Reference_ID()).first();
		if (paymentBankAccountMappingsReferenceLimiting == null) {
			log.severe("No Reference in the System for Payment Bank Account Mappings");
			transaction.rollback();
			transaction.close();
			return false;
		}

		// So that we don't have to hard code these values, get the ones stored for the
		// screen's dynamic validation
		List<MReference> referencesToCreatePaymentMappingsFor = new Query(context, MReference.Table_Name,
				paymentBankAccountMappingsReferenceLimiting.getWhereClause(), getTransactionName()).list();
		if (referencesToCreatePaymentMappingsFor == null) {
			referencesToCreatePaymentMappingsFor = new ArrayList<MReference>();
		}
		for (MReference referenceToCreatePaymentMappingsFor : referencesToCreatePaymentMappingsFor) {
			MBHPaymentRef paymentRef = new MBHPaymentRef(context, 0, getTransactionName());
			paymentRef.setAD_Org_ID(getAD_Org_ID());
			paymentRef.setAD_Reference_ID(referenceToCreatePaymentMappingsFor.getAD_Reference_ID());
			if (!paymentRef.save()) {
				String errorMessage = "Payment Bank Account mapping NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
		}

		return true;
	}

	/**
	 * Create a bank account for the client and assign it to the bank
	 *
	 * @param clientName
	 * @param accountName
	 * @param isDefault
	 * @param bankId
	 * @param inTransitAccountValue
	 * @return
	 */
	private boolean createAndSaveBankAccount(String clientName, String accountName, boolean isDefault, int bankId,
			String inTransitAccountValue) {
		MBankAccount bankAccount = new MBankAccount(context, 0, getTransactionName());
		bankAccount.setIsActive(true);
		bankAccount.setIsDefault(isDefault);
		bankAccount.setName(clientName + " " + accountName + SUFFIX_BANK_ACCOUNT_NAME);
		bankAccount.setAD_Org_ID(getAD_Org_ID());
		bankAccount.setC_Bank_ID(bankId);
		bankAccount.setAccountNo(accountName + SUFFIX_BANK_ACCOUNT_NUMBER);
		bankAccount.setC_Currency_ID(accountSchema.getC_Currency_ID());
		bankAccount.setBankAccountType(MBankAccount.BANKACCOUNTTYPE_Cash);

		if (!bankAccount.save()) {
			String errorMessage = accountName + " Bank Account NOT inserted";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
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

	/**
	 * Update the account mappings for the bank accounts that are created.
	 *
	 * @param bankAccount
	 * @param inTransitAccount
	 * @return
	 */
	private boolean updateAccountMappingsForBankAccount(MBankAccount bankAccount, MAccount inTransitAccount) {
		X_C_BankAccount_Acct accountMapping = new Query(context, X_C_BankAccount_Acct.Table_Name,
				X_C_BankAccount_Acct.COLUMNNAME_C_BankAccount_ID + "=?", getTransactionName())
				.setParameters(bankAccount.getC_BankAccount_ID()).first();
		if (accountMapping == null) {
			log.severe("No Account Mapping for Bank Account");
			transaction.rollback();
			transaction.close();
			return false;
		}
		if (inTransitAccount != null) {
			accountMapping.setB_InTransit_Acct(inTransitAccount.getC_ValidCombination_ID());
		}
		accountMapping.setB_Asset_Acct(accountMapping.getB_InTransit_Acct());
		if (!accountMapping.save()) {
			String errorMessage = "Account Mapping NOT updated";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}

		return true;
	}

	/**
	 * Get the valid combination for an account or create one if none currently
	 * exists and return it.
	 *
	 * @param accountValue
	 * @return
	 */
	private MAccount getOrCreateValidCombination(String accountValue) {
		MElementValue accountElement = new Query(context, MElementValue.Table_Name,
				MElementValue.COLUMNNAME_Value + "=? AND " + MElementValue.COLUMNNAME_AD_Client_ID + "=?",
				getTransactionName()).setParameters(accountValue, getAD_Client_ID()).first();
		if (accountElement == null) {
			return null;
		}
		// See if an account already exists for this account value
		MAccount account = new Query(context, MAccount.Table_Name,
				MAccount.COLUMNNAME_AD_Client_ID + "=? AND " + MAccount.COLUMNNAME_Account_ID + "=?",
				getTransactionName())
				.setParameters(accountElement.getAD_Client_ID(), accountElement.getC_ElementValue_ID()).first();
		if (account != null) {
			return account;
		}

		account = new MAccount(context, 0, getTransactionName());
		account.setC_AcctSchema_ID(accountSchema.getC_AcctSchema_ID());
		account.setAccount_ID(accountElement.getC_ElementValue_ID());
		account.setValueDescription();
		if (!account.save()) {
			log.severe("Account NOT inserted");
			transaction.rollback();
			transaction.close();
			return null;
		}
		return account;
	}

	/**
	 * Get a map of all accounts for this client
	 *
	 * @return map of accounts
	 */
	private Map<Integer, MElementValue> getAllElementValues() {
		PO.setCrossTenantSafe();
		List<MElementValue> accountElementsForTwoClients = new Query(context, MElementValue.Table_Name,
				MElementValue.COLUMNNAME_AD_Client_ID + " IN (?,?)", getTransactionName())
				.setParameters(MClient_BH.CLIENTID_CONFIG, getAD_Client_ID()).list();
		PO.clearCrossTenantSafe();

		Map<String, MElementValue> newClientAccountElementIdsByValue = accountElementsForTwoClients.stream()
				.filter(elementValue -> elementValue.getAD_Client_ID() == getAD_Client_ID())
				.collect(Collectors.toMap(MElementValue::getValue, elementValue -> elementValue));

		return accountElementsForTwoClients.stream()
				.filter(elementValue -> elementValue.getAD_Client_ID() == MClient_BH.CLIENTID_CONFIG)
				.collect(Collectors.toMap(MElementValue::getC_ElementValue_ID,
						elementValue -> newClientAccountElementIdsByValue.getOrDefault(elementValue.getValue(),
								new MElementValue(this.context, 0, getTransactionName()))));
	}

	/**
	 * Fetch all info values from the configuration client
	 *
	 * @return a map of the info values
	 */
	private Map<Integer, MBHPayerInfoFldVal> getDefaultPayerInfoFieldValuesMap() {
		PO.setCrossTenantSafe();
		List<MBHPayerInfoFldVal> infoValuesList = new Query(context, MBHPayerInfoFldVal.Table_Name,
				MBHPayerInfoFldVal.COLUMNNAME_AD_Client_ID + "=?", getTransactionName())
				.setParameters(MClient_BH.CLIENTID_CONFIG).list();
		PO.clearCrossTenantSafe();
		return infoValuesList.stream()
				.collect(Collectors.toMap(MBHPayerInfoFldVal::getBH_Payer_Info_Fld_Val_ID, Function.identity()));
	}

	/**
	 * Custom warehouse configuration
	 */
	public boolean updateWarehouseLocatorSetUp() {
		PO.setCrossTenantSafe();
		MWarehouse_BH configurationClientWarehouse =
				new Query(this.context, MWarehouse_BH.Table_Name, MWarehouse.COLUMNNAME_AD_Client_ID + "=?",
						getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG).first();
		PO.clearCrossTenantSafe();

		// get the default warehouse and locator->rename and set to locator as default
		MWarehouse_BH warehouse = new Query(this.context, MWarehouse.Table_Name,
				MWarehouse.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setParameters(client.getAD_Client_ID())
				.first();
		MLocator locator = new Query(this.context, MLocator.Table_Name,
				MWarehouse.COLUMNNAME_AD_Client_ID + "=? AND " + MLocator.COLUMNNAME_M_Warehouse_ID + "=?",
				getTransactionName()).setParameters(getAD_Client_ID(), warehouse.getM_Warehouse_ID()).first();
		locator.setIsDefault(true);
		locator.setValue(organization.getName());
		warehouse.setName(organization.getName());
		warehouse.setValue(organization.getName());
		warehouse.setBH_DefaultWarehouse(true);
		warehouse.setIsDisallowNegativeInv(configurationClientWarehouse.isDisallowNegativeInv());
		if (!locator.save()) {
			transaction.rollback();
			transaction.close();
			return false;
		}
		if (!warehouse.save()) {
			transaction.rollback();
			transaction.close();
			return false;
		}
		return true;
	}

	/**
	 * Create a price list and an associated version
	 *
	 * @param priceListName        name of the price-list
	 * @param priceListVersionName name of the price-list version
	 * @param isSalePriceList
	 * @return success or failure
	 */
	public boolean createPriceList(String priceListName, String priceListVersionName, boolean isSalePriceList) {
		// // delete default price-list and version
		MPriceList priceList = new Query(this.context, MPriceList.Table_Name,
				MPriceList.COLUMNNAME_AD_Client_ID + "=? AND " + MPriceList.COLUMNNAME_Name + " =?",
				getTransactionName()).setParameters(getAD_Client_ID(), DEFAULT_IDEMPIERE_ENTITY_NAME).first();
		if (priceList != null) {
			MPriceListVersion defaultPriceListVersion = priceList.getPriceListVersion(null);
			if (defaultPriceListVersion.delete(true)) {
				// TODO Reset address on this warehouse
				priceList.delete(true);
			}
		}
		// create default price-lists for sales and purchases
		MPriceList bandaPriceList = new MPriceList(this.context, 0, getTransactionName());
		bandaPriceList.setName(priceListName);
		bandaPriceList.setIsSOPriceList(isSalePriceList);
		bandaPriceList.setIsDefault(true);
		bandaPriceList.setAD_Org_ID(getAD_Org_ID());
		bandaPriceList.setIsActive(true);
		bandaPriceList.setC_Currency_ID(client.getC_Currency_ID());
		if (!bandaPriceList.save()) {
			log.log(Level.SEVERE, "Price-list not saved");
			transaction.rollback();
			transaction.close();
			return false;
		}

		// GO-2240 Make sure the price list is valid from a date in the past because
		// usually clients want to enter stuff
		// they've recently received before today
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Timestamp.from(Instant.now()));
		calendar.add(Calendar.YEAR, -1);

		// Create discount schemas to be used with new price lists
		MDiscountSchema bandaDiscountSchema = new MDiscountSchema(context, 0, getTransactionName());
		bandaDiscountSchema.setName("Default Price List Schema - DO NOT CHANGE");
		bandaDiscountSchema.setValidFrom(new Timestamp(calendar.getTime().getTime()));
		bandaDiscountSchema.setDiscountType(MDiscountSchema.DISCOUNTTYPE_Pricelist);
		bandaDiscountSchema.setFlatDiscount(BigDecimal.ZERO);
		bandaDiscountSchema.setCumulativeLevel(MDiscountSchema.CUMULATIVELEVEL_Line);
		bandaDiscountSchema.setProcessing(false);
		if (!bandaDiscountSchema.save()) {
			log.log(Level.SEVERE, "Discount schema not saved");
			transaction.rollback();
			transaction.close();
		}

		MDiscountSchemaLine bandaDiscountSchemaLine = new MDiscountSchemaLine(context, 0, getTransactionName());
		bandaDiscountSchemaLine.setM_DiscountSchema_ID(bandaDiscountSchema.get_ID());
		bandaDiscountSchemaLine.setSeqNo(10);
		bandaDiscountSchemaLine.setConversionDate(new Timestamp(System.currentTimeMillis()));
		bandaDiscountSchemaLine.setList_Base(MDiscountSchemaLine.LIST_BASE_ListPrice);
		bandaDiscountSchemaLine.setList_Discount(BigDecimal.ZERO);
		bandaDiscountSchemaLine.setList_Rounding(MDiscountSchemaLine.LIST_ROUNDING_CurrencyPrecision);
		bandaDiscountSchemaLine.setStd_Base(MDiscountSchemaLine.STD_BASE_StandardPrice);
		bandaDiscountSchemaLine.setStd_Discount(BigDecimal.ZERO);
		bandaDiscountSchemaLine.setStd_Rounding(MDiscountSchemaLine.LIST_ROUNDING_CurrencyPrecision);
		bandaDiscountSchemaLine.setLimit_Base(MDiscountSchemaLine.LIMIT_BASE_LimitPOPrice);
		bandaDiscountSchemaLine.setLimit_Discount(BigDecimal.ZERO);
		bandaDiscountSchemaLine.setLimit_Rounding(MDiscountSchemaLine.LIST_ROUNDING_CurrencyPrecision);
		MConversionType conversionType =
				new Query(context, MConversionType.Table_Name, "Name=?", getTransactionName()).setParameters("Spot").first();
		bandaDiscountSchemaLine.setC_ConversionType_ID(conversionType.get_ID());
		if (!bandaDiscountSchemaLine.save()) {
			log.log(Level.SEVERE, "Discount schema line not saved");
			transaction.rollback();
			transaction.close();
		}

		// create default price-list version
		MPriceListVersion priceListVersion = new MPriceListVersion(context, 0, getTransactionName());
		priceListVersion.setName(priceListVersionName);
		priceListVersion.setIsActive(true);
		priceListVersion.setM_PriceList_ID(bandaPriceList.get_ID());
		priceListVersion.setM_DiscountSchema_ID(bandaDiscountSchema.get_ID());
		priceListVersion.setValidFrom(new Timestamp(calendar.getTime().getTime()));
		if (!priceListVersion.save()) {
			log.log(Level.SEVERE, "Price-list version not saved");
			transaction.rollback();
			transaction.close();
			return false;
		}

		return true;
	}

	/**
	 * Configure accounting periods
	 */
	public boolean openCalendarYearPeriods() {
		final String CALENDAR_PROCESS_INFO_NAME = "Calendar Process Info";
		final String CALENDAR_PROCESS_PARAM_NAME = "PeriodAction";
		final String CALENDAR_PROCESS_PARAM_ACTION = "O";
		final String CALENDAR_PROCESS_PARAM_INFO = "Open Period";
		final String CALENDAR_PROCESS_NAME = "C_Period_Process";

		boolean result = false;
		// un-check automatic period control in accounting schema
		MAcctSchema accountingSchema = new Query(context, MAcctSchema.Table_Name,
				MAcctSchema.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setParameters(getAD_Client_ID())
				.first();
		accountingSchema.setAutoPeriodControl(false);
		if (!accountingSchema.save()) {
			log.log(Level.SEVERE, "Failed: In activate automatic period control");
			transaction.rollback();
			transaction.close();
		}

		CacheMgt.get().resetLocalCache();
		// run 'Open All' process on all documents for the calendar period
		MYear year = new Query(context, MYear.Table_Name, MYear.COLUMNNAME_AD_Client_ID + "=?", getTransactionName())
				.setParameters(getAD_Client_ID()).first();
		List<MPeriod> calendarPeriods = new Query(context, MPeriod.Table_Name,
				MPeriod.COLUMNNAME_AD_Client_ID + "=? AND " + MPeriod.COLUMNNAME_C_Year_ID + "=?", getTransactionName())
				.setParameters(getAD_Client_ID(), year.getC_Year_ID()).list();

		// set the record IDs for the periods to be opened.
		List<Integer> recordIDs = calendarPeriods.stream().map(MPeriod::get_ID).collect(Collectors.toList());

		ProcessInfoParameter parameter1 = new ProcessInfoParameter(CALENDAR_PROCESS_PARAM_NAME,
				CALENDAR_PROCESS_PARAM_ACTION, "", CALENDAR_PROCESS_PARAM_INFO, "");
		ProcessInfo processInfo = new ProcessInfo(CALENDAR_PROCESS_INFO_NAME, 0, 0, 0);
		processInfo.setParameter(new ProcessInfoParameter[]{parameter1});
		processInfo.setRecord_IDs(recordIDs);

		MProcess process = new Query(context, MProcess.Table_Name, MProcess.COLUMNNAME_Value + "=?",
				getTransactionName()).setParameters(CALENDAR_PROCESS_NAME).first();
		if (process == null) {
			log.severe("Failure: Could not find process");
		}
		// Can use this save to resume process?
		MPInstance instance = new MPInstance(context, 0, null);
		instance.setAD_Process_ID(process.get_ID());
		instance.setRecord_ID(0);
		if (!instance.save()) {
			log.warning("Failure: Could not save process instance");
		}
		processInfo.setAD_PInstance_ID(instance.get_ID());
		result = process.processIt(processInfo, null);
		return result;
	}

	public boolean createProductAttributeSets() {
		// Get all active, attribute sets from the default configuration client
		PO.setCrossTenantSafe();
		List<MAttributeSet_BH> attributeSets = new Query(context, MAttributeSet.Table_Name,
				MAttributeSet.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
				.setParameters(MClient_BH.CLIENTID_CONFIG).list();

		List<Object> parameters = new ArrayList<>();
		String whereClauseParameterList = QueryUtil.getWhereClauseAndSetParametersForSet(
				attributeSets.stream().map(MAttributeSet_BH::get_ID).collect(Collectors.toSet()), parameters);
		List<X_M_AttributeSetExclude> attributeSetExclusions = new Query(context, X_M_AttributeSetExclude.Table_Name,
				X_M_AttributeSetExclude.COLUMNNAME_M_AttributeSet_ID + " IN (" + whereClauseParameterList + ")",
				getTransactionName()).setParameters(parameters).setOnlyActiveRecords(true).list();
		PO.clearCrossTenantSafe();

		if (attributeSets.isEmpty()) {
			String errorMessage = "Default AttributeSets NOT found";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}

		// set serial control for this client
		MSerNoCtl_BH serialControl = new MSerNoCtl_BH(context, 0, getTransactionName());
		serialControl.setName(MSerNoCtl_BH.DEFAULT_SERIAL_COUNTER_NAME);
		serialControl.setStartNo(MSerNoCtl_BH.DEFAULT_START_NO);
		serialControl.setIncrementNo(MSerNoCtl_BH.DEFAULT_INCREMENT_NO);
		serialControl.setCurrentNext(MSerNoCtl_BH.DEFAULT_CURRENT_NEXT);
		serialControl.setBH_Locked(MSerNoCtl_BH.DEFAULT_BH_LOCKED);
		if (!serialControl.save()) {
			String errorMessage = "Default Serial Control NOT inserted";
			log.log(Level.SEVERE, errorMessage);
			info.append(errorMessage);
			transaction.rollback();
			transaction.close();
			return false;
		}

		for (MAttributeSet attributeSet : attributeSets) {
			MAttributeSet_BH newAttributeSet = new MAttributeSet_BH(context, 0, getTransactionName());
			newAttributeSet.setName(attributeSet.getName());
			newAttributeSet.setDescription(attributeSet.getDescription());

			newAttributeSet.setM_SerNoCtl_ID(serialControl.getM_SerNoCtl_ID());

			newAttributeSet.setIsLot(attributeSet.isLot());
			newAttributeSet.setIsGuaranteeDate(attributeSet.isGuaranteeDate());
			newAttributeSet.setGuaranteeDays(attributeSet.getGuaranteeDays());
			newAttributeSet.setIsInstanceAttribute(attributeSet.isInstanceAttribute());
			newAttributeSet.setUseGuaranteeDateForMPolicy(attributeSet.isUseGuaranteeDateForMPolicy());
			newAttributeSet.setBH_Locked(true);

			if (!newAttributeSet.save()) {
				String errorMessage = "Default AttributeSet NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}

			// Add exclusions (largely so ASIs aren't required on sales orders)
			List<X_M_AttributeSetExclude> exclusionsForThisAttributeSet =
					attributeSetExclusions.stream().filter(exclusion -> exclusion.getM_AttributeSet_ID() == attributeSet.get_ID())
							.collect(Collectors.toList());
			for (X_M_AttributeSetExclude exclusion : exclusionsForThisAttributeSet) {
				X_M_AttributeSetExclude newExclusion = new X_M_AttributeSetExclude(context, 0, getTransactionName());
				newExclusion.setAD_Table_ID(exclusion.getAD_Table_ID());
				newExclusion.setM_AttributeSet_ID(newAttributeSet.get_ID());
				newExclusion.setIsSOTrx(exclusion.isSOTrx());
				newExclusion.saveEx();
			}
		}

		return true;
	}

	/**
	 * Update client users
	 */
	public boolean configureClientUsers() {
		// remove admin and user as customers/business partners
		List<MBPartner_BH> businessPartners = new Query(context, MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MBPartner_BH.COLUMNNAME_IsCustomer + "=?",
				getTransactionName()).setParameters(getAD_Client_ID(), true).list();
		businessPartners.forEach((businessPartner) -> {
			businessPartner.setIsActive(false);
			if (!businessPartner.save()) {
				log.warning("Failure: Could not save updates for business partner");
			}
		});
		return true;
	}

	/**
	 * Core setup (MSetup.createClient) puts the new client's accounting & request processors on the seed
	 * every-few-minutes schedules (SystemIDs.SCHEDULE_10_MINUTES/SCHEDULE_15_MINUTES), which would run them all
	 * day, every day. Move them to the shared schedules and stagger their first run into the overnight load
	 * trough (accounting 00:00-01:59, request 02:00-03:44), matching the fleet-wide spread done in GO-3636.
	 * This must happen before AdempiereServerMgr ever loads the processors (it only picks up new ones on a
	 * server restart/reload) -- once a processor is running, it rewrites DateNextRun from its in-memory
	 * schedule on every run, so any later DB correction is silently lost (GO-3654).
	 *
	 * @return Whether the processors were moved to the shared overnight schedules
	 */
	public boolean updateProcessorRunSchedules() {
		if (new Query(context, MSchedule.Table_Name, MSchedule.COLUMNNAME_AD_Schedule_ID + " IN (?,?)",
				getTransactionName())
				.setParameters(SCHEDULE_ACCOUNTING_PROCESSOR_ID, SCHEDULE_REQUEST_PROCESSOR_ID)
				.setOnlyActiveRecords(true).count() != 2) {
			log.severe("Failure: The shared overnight processor schedules don't exist in this environment");
			return false;
		}

		// Stateless stagger: each client gets a deterministic slot in the trough window based on its ID
		LocalDateTime tomorrow = LocalDate.now().plusDays(1).atStartOfDay();
		Timestamp accountingProcessorNextRun = Timestamp.valueOf(tomorrow.plusMinutes(
				ACCT_PROCESSOR_TROUGH_START_MINUTES + getAD_Client_ID() % ACCT_PROCESSOR_TROUGH_WINDOW_MINUTES));
		Timestamp requestProcessorNextRun = Timestamp.valueOf(tomorrow.plusMinutes(
				REQUEST_PROCESSOR_TROUGH_START_MINUTES + getAD_Client_ID() % REQUEST_PROCESSOR_TROUGH_WINDOW_MINUTES));

		List<MAcctProcessor> accountingProcessors = new Query(context, MAcctProcessor.Table_Name,
				MAcctProcessor.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setParameters(getAD_Client_ID())
				.list();
		for (MAcctProcessor accountingProcessor : accountingProcessors) {
			accountingProcessor.setAD_Schedule_ID(SCHEDULE_ACCOUNTING_PROCESSOR_ID);
			accountingProcessor.setDateNextRun(accountingProcessorNextRun);
			if (!accountingProcessor.save()) {
				log.severe("Failure: Accounting processor not moved to the shared overnight schedule");
				return false;
			}
		}

		List<MRequestProcessor> requestProcessors = new Query(context, MRequestProcessor.Table_Name,
				MRequestProcessor.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setParameters(getAD_Client_ID())
				.list();
		for (MRequestProcessor requestProcessor : requestProcessors) {
			requestProcessor.setAD_Schedule_ID(SCHEDULE_REQUEST_PROCESSOR_ID);
			requestProcessor.setDateNextRun(requestProcessorNextRun);
			if (!requestProcessor.save()) {
				log.severe("Failure: Request processor not moved to the shared overnight schedule");
				return false;
			}
		}
		return true;
	}

	/**
	 * Create default business partners for new clients
	 *
	 * @return
	 */
	public boolean createDefaultBusinessPartners() {
		Map<Integer, MBPGroup_BH> defaultBusinessPartnerGroups = addDefaultBusinessPartnerGroups();
		if (defaultBusinessPartnerGroups.isEmpty()) {
			log.warning("Failure: Could not find a business partner group for this client");
			return false;
		}

		PO.setCrossTenantSafe();
		MClient configurationClient = MClient_BH.get(MClient_BH.CLIENTID_CONFIG);
		List<MBPartner_BH> defaultBusinessPartners = new Query(this.context, MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MBPartner_BH.COLUMNNAME_Name + " NOT LIKE ? || ' %' AND " +
						MBPartner_BH.COLUMNNAME_Name + "!=?", getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG,
				configurationClient.getName(), DEFAULT_IDEMPIERE_ENTITY_NAME).setOnlyActiveRecords(true).list();
		PO.clearCrossTenantSafe();

		I_C_Location clientLocation = MOrgInfo_BH.get(Env.getCtx(), getAD_Org_ID()).getC_Location();

		Map<Integer, Integer> clientBusinessPartnerIdsByDefaultBusinessPartnerId = new HashMap<>();
		for (MBPartner_BH defaultBusinessPartner : defaultBusinessPartners) {
			MBPartner_BH clientBusinessPartner = new MBPartner_BH(context, 0, getTransactionName());
			MBPartner_BH.copyValues(defaultBusinessPartner, clientBusinessPartner);
			clientBusinessPartner.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
			clientBusinessPartner.setM_PriceList_ID(0);
			clientBusinessPartner.setPO_PriceList_ID(0);
			clientBusinessPartner.setC_PaymentTerm_ID(0);
			clientBusinessPartner.setPO_PaymentTerm_ID(0);
			clientBusinessPartner.setBH_NeedAdditionalVisitInfo(defaultBusinessPartner.isBH_NeedAdditionalVisitInfo());
			if (defaultBusinessPartner.getName().contains(PREFIX_OTC_BUSINESS_PARTNER)) {
				clientBusinessPartner.setName(PREFIX_OTC_BUSINESS_PARTNER + client.getName());
			}
			if (defaultBusinessPartnerGroups.get(defaultBusinessPartner.getC_BP_Group_ID()) != null) {
				clientBusinessPartner.setC_BP_Group_ID(
						defaultBusinessPartnerGroups.get(defaultBusinessPartner.getC_BP_Group_ID()).get_ID());
			}

			if (!clientBusinessPartner.save()) {
				log.warning("Failure: Could not save default business partner");
				return false;
			}
			clientBusinessPartnerIdsByDefaultBusinessPartnerId.put(defaultBusinessPartner.get_ID(),
					clientBusinessPartner.get_ID());

			// Create a location for this BP
			MBPartnerLocation businessPartnerLocation = new MBPartnerLocation(this.context, 0, getTransactionName());
			businessPartnerLocation.setAD_Org_ID(0);
			businessPartnerLocation.setC_BPartner_ID(clientBusinessPartner.get_ID());
			businessPartnerLocation.setC_Location_ID(clientLocation.getC_Location_ID());
			businessPartnerLocation.setName("Default Location");
			businessPartnerLocation.saveEx();
		}

		return addPayerInformationFields(clientBusinessPartnerIdsByDefaultBusinessPartnerId);
	}

	/**
	 * Create default business partner groups for new clients
	 *
	 * @return A map of the default BP Group IDs to the clients BP Groups
	 */
	private Map<Integer, MBPGroup_BH> addDefaultBusinessPartnerGroups() {
		Map<Integer, MBPGroup_BH> clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId = new HashMap<>();
		PO.setCrossTenantSafe();
		List<MBPGroup_BH> defaultBusinessPartnerGroups = new Query(this.context, MBPGroup_BH.Table_Name,
				MBPGroup_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MBPGroup_BH.COLUMNNAME_Name + " !=?",
				getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG, DEFAULT_IDEMPIERE_ENTITY_NAME)
				.list();
		PO.clearCrossTenantSafe();
		defaultBusinessPartnerGroups.forEach((defaultBusinessPartnerGroup) -> {
			MBPGroup_BH clientBusinessPartnerGroup = new MBPGroup_BH(context, 0, getTransactionName());
			MBPGroup.copyValues(defaultBusinessPartnerGroup, clientBusinessPartnerGroup);
			clientBusinessPartnerGroup.setM_PriceList_ID(0);
			clientBusinessPartnerGroup.setPO_PriceList_ID(0);
			clientBusinessPartnerGroup.setBH_SubType(defaultBusinessPartnerGroup.getBH_SubType());
			if (!clientBusinessPartnerGroup.save()) {
				log.warning("Failure: Could not save default business partner group");
			}

			clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId.put(defaultBusinessPartnerGroup.get_ID(),
					clientBusinessPartnerGroup);
		});

		// Add a mapping for the standard BP Group
		PO.setCrossTenantSafe();
		List<MBPGroup_BH> defaultThenClientStandardBusinessPartnerGroups = new Query(this.context, MBPGroup_BH.Table_Name,
				MBPGroup_BH.COLUMNNAME_AD_Client_ID + " IN (?,?) AND " + MBPGroup_BH.COLUMNNAME_Name + "=?",
				getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG, getAD_Client_ID(),
				DEFAULT_IDEMPIERE_ENTITY_NAME).setOrderBy(MClient_BH.COLUMNNAME_AD_Client_ID).list();
		PO.clearCrossTenantSafe();
		clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId.put(
				defaultThenClientStandardBusinessPartnerGroups.get(0).getC_BP_Group_ID(),
				defaultThenClientStandardBusinessPartnerGroups.get(1));

		// While the accounting is automatically created for the new BP Groups, some accounts may need to be updated
		PO.setCrossTenantSafe();

		List<Object> parameters = new ArrayList<>();
		String businessPartnerGroupIdWhereClause =
				QueryUtil.getWhereClauseAndSetParametersForSet(
						clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId.keySet(), parameters);

		// Create a BP Group account map to match the defaults
		List<X_C_BP_Group_Acct> defaultBusinessPartnerGroupAccounts = new Query(this.context, X_C_BP_Group_Acct.Table_Name,
				X_C_BP_Group_Acct.COLUMNNAME_C_BP_Group_ID + " IN (" + businessPartnerGroupIdWhereClause + ")",
				getTransactionName()).setParameters(parameters).list();
		parameters = new ArrayList<>();
		businessPartnerGroupIdWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId.values().stream().map(MBPGroup_BH::getC_BP_Group_ID)
						.collect(Collectors.toSet()), parameters);

		List<X_C_BP_Group_Acct> clientBusinessPartnerGroupAccounts = new Query(this.context, X_C_BP_Group_Acct.Table_Name,
				X_C_BP_Group_Acct.COLUMNNAME_C_BP_Group_ID + " IN (" + businessPartnerGroupIdWhereClause + ")",
				getTransactionName()).setParameters(parameters).list();
		Map<Integer, X_C_BP_Group_Acct> clientBusinessPartnerGroupAccountsByClientBusinessPartnerGroupId =
				clientBusinessPartnerGroupAccounts.stream().collect(Collectors.toMap(X_C_BP_Group_Acct::getC_BP_Group_ID,
						clientBusinessPartnerGroupAccount -> clientBusinessPartnerGroupAccount));

		Map<Integer, X_C_BP_Group_Acct> clientBusinessPartnerGroupAccountsByDefaultBusinessPartnerGroupId =
				defaultBusinessPartnerGroupAccounts.stream().collect(Collectors.toMap(X_C_BP_Group_Acct::getC_BP_Group_ID,
						defaultBusinessPartnerGroupAccount -> clientBusinessPartnerGroupAccountsByClientBusinessPartnerGroupId.get(
								clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId.get(
										defaultBusinessPartnerGroupAccount.getC_BP_Group_ID()).getC_BP_Group_ID())));

		int defaultAccountSchemaId = defaultBusinessPartnerGroupAccounts.get(0).getC_AcctSchema_ID();
		MAcctSchemaDefault defaultAccountSchemaDefaults = new Query(this.context, MAcctSchemaDefault.Table_Name,
				MAcctSchemaDefault.COLUMNNAME_AD_Client_ID + "=? AND " + MAcctSchemaDefault.COLUMNNAME_C_AcctSchema_ID + "=?",
				this.getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG, defaultAccountSchemaId).first();

		// Create an account ID map to match the default with the newly created
		List<MElementValue> defaultAccounts =
				new Query(this.context, MElementValue.Table_Name, MElementValue.COLUMNNAME_AD_Client_ID + "=?",
						this.getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG).list();
		List<MElementValue> clientAccounts =
				new Query(this.context, MElementValue.Table_Name, null, this.getTransactionName()).setClient_ID().list();
		int clientAccountSchemaId = clientBusinessPartnerGroupAccounts.get(0).getC_AcctSchema_ID();

		MElementValue emptyAccount = new MElementValue(this.context, 0, this.getTransactionName());
		Map<Integer, Integer> clientAccountIdsByDefaultAccountId = defaultAccounts.stream().collect(
				Collectors.toMap(MElementValue::getC_ElementValue_ID, defaultAccount -> clientAccounts.stream()
						.filter(clientAccount -> clientAccount.getValue().equals(defaultAccount.getValue())).findFirst()
						.orElse(emptyAccount).getC_ElementValue_ID()));

		// The config client schema will match the schema loaded from the Excel file
		// So, if any of the default BP group accounts don't match the default, we need to update the client BP created
		// accounts so they match the different mapping
		for (X_C_BP_Group_Acct defaultBPGroupAccount : defaultBusinessPartnerGroupAccounts) {
			X_C_BP_Group_Acct clientBusinessPartnerGroupAccount =
					clientBusinessPartnerGroupAccountsByDefaultBusinessPartnerGroupId.get(
							defaultBPGroupAccount.getC_BP_Group_ID());

			// NB: while this code is somewhat duplicated between "if" statements, extracting it into a separate
			// function did not increase readability and/or maintainability, so the code was kept here

			// Check to see if the customer receivables (A/R) account differs from default
			if (defaultBPGroupAccount.getC_Receivable_Acct() != defaultAccountSchemaDefaults.getC_Receivable_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getC_Receivable_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setC_Receivable_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the customer pre-payment account differs from default
			if (defaultBPGroupAccount.getC_Prepayment_Acct() != defaultAccountSchemaDefaults.getC_Prepayment_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getC_Prepayment_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setC_Prepayment_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the vendor liability (A/P) account differs from default
			if (defaultBPGroupAccount.getV_Liability_Acct() != defaultAccountSchemaDefaults.getV_Liability_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getV_Liability_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setV_Liability_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the vendor liability (A/P) for services account differs from default
			if (defaultBPGroupAccount.getV_Liability_Services_Acct() !=
					defaultAccountSchemaDefaults.getV_Liability_Services_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getV_Liability_Services_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setV_Liability_Services_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the vendor prepayment account differs from default
			if (defaultBPGroupAccount.getV_Prepayment_Acct() != defaultAccountSchemaDefaults.getV_Prepayment_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getV_Prepayment_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setV_Prepayment_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the expense payment discount account differs from default
			if (defaultBPGroupAccount.getPayDiscount_Exp_Acct() != defaultAccountSchemaDefaults.getPayDiscount_Exp_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getPayDiscount_Exp_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setPayDiscount_Exp_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the revenue payment discount account differs from default
			if (defaultBPGroupAccount.getPayDiscount_Rev_Acct() != defaultAccountSchemaDefaults.getPayDiscount_Rev_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getPayDiscount_Rev_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setPayDiscount_Rev_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the write-off account differs from default
			if (defaultBPGroupAccount.getWriteOff_Acct() != defaultAccountSchemaDefaults.getWriteOff_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getWriteOff_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setWriteOff_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the non-invoiced receipts account differs from default
			if (defaultBPGroupAccount.getNotInvoicedReceipts_Acct() !=
					defaultAccountSchemaDefaults.getNotInvoicedReceipts_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getNotInvoicedReceipts_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setNotInvoicedReceipts_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the unearned revenue account differs from default
			if (defaultBPGroupAccount.getUnEarnedRevenue_Acct() != defaultAccountSchemaDefaults.getUnEarnedRevenue_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getUnEarnedRevenue_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setUnEarnedRevenue_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Check to see if the customer receivables (A/R) for services account differs from default
			if (defaultBPGroupAccount.getC_Receivable_Services_Acct() !=
					defaultAccountSchemaDefaults.getC_Receivable_Services_Acct()) {
				I_C_ValidCombination nonDefaultAccount = defaultBPGroupAccount.getC_Receivable_Services_A();
				MAccount clientAccount = getAccount(clientAccountSchemaId,
						clientAccountIdsByDefaultAccountId.get(nonDefaultAccount.getAccount_ID()));
				clientBusinessPartnerGroupAccount.setC_Receivable_Services_Acct(clientAccount.getC_ValidCombination_ID());
			}

			// Finally, save the thing
			clientBusinessPartnerGroupAccount.saveEx();
		}

		PO.clearCrossTenantSafe();

		return clientBusinessPartnerGroupByDefaultBusinessPartnerGroupId;
	}

	/**
	 * A sugar method to get the account more easily
	 *
	 * @param clientAccountSchemaId The client schema ID
	 * @param accountId             The account ID to look for
	 * @return The found or created account
	 */
	private MAccount getAccount(int clientAccountSchemaId, int accountId) {
		return MAccount.get(this.context, this.getAD_Client_ID(), 0, clientAccountSchemaId, accountId, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, this.getTransactionName());
	}

	/**
	 * Get Client
	 *
	 * @return AD_Client_ID
	 */
	public int getAD_Client_ID() {
		return client.getAD_Client_ID();
	}

	/**
	 * Get AD_Org_ID
	 *
	 * @return AD_Org_ID
	 */
	public int getAD_Org_ID() {
		return organization.getAD_Org_ID();
	}

	/**
	 * Get AccountSchema
	 *
	 * @return AccountSchema
	 */
	public MAcctSchema getAccountSchema() {
		return accountSchema;
	}

	/**
	 * Get Info
	 *
	 * @return Info
	 */
	public String getInfo() {
		return info.toString();
	}

	/**
	 * Get Info and then reset it
	 *
	 * @return Info
	 */
	public String getThenResetInfo() {
		String infoToReturn = getInfo();
		resetInfo();
		return StringUtil.isNullOrEmpty(infoToReturn) ? null : infoToReturn;
	}

	/**
	 * Rollback Internal Transaction
	 */
	public void rollback() {
		try {
			transaction.rollback();
			transaction.close();
		} catch (Exception e) {
			log.warning("Error occured when rolling back the internal transaction: " + e.getMessage());
		}
	}

	/**
	 * Get the internal transaction name for the Banda setup process
	 *
	 * @return The transaction name
	 */
	public String getTransactionName() {
		return transaction.getTrxName();
	}

	public void resetInfo() {
		info.setLength(0);
	}
}
