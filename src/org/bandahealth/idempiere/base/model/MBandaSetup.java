package org.bandahealth.idempiere.base.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaDefault;
import org.compiere.model.MBank;
import org.compiere.model.MBankAccount;
import org.compiere.model.MClient;
import org.compiere.model.MDocType;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MProductCategoryAcct;
import org.compiere.model.MRefList;
import org.compiere.model.MRefTable;
import org.compiere.model.MReference;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.MTable;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Document_Action_Access;
import org.compiere.model.X_C_BankAccount_Acct;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

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

		/**
		 * In iDempiere, accounts are mapped to many different things, such as bank
		 * accounts and charges. The default account mappings generated map different
		 * accounts to the Bank Asset account (B_Asset) and the Bank In-Transit account
		 * (B_InTransit). Based on a recommendation from Chuck, we simplify this mapping
		 * and choose to map these accounts to the same default account because we don't
		 * ever upload bank statements, which is the default way iDempiere transfers
		 * value from B_InTransit to B_Asset. So, we need to make the B_Asset account
		 * match the B_InTransit account.
		 */
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

		/**
		 * The default account mappings generated map different accounts to the Vendor
		 * Liability account (V_Liability) and the Bank Payment Select account
		 * (B_PaymentSelect). Based on a recommendation from Chuck, we simplify this
		 * mapping and choose to map these accounts to the same default account. So, we
		 * need to make the B_PaymentSelect account match the V_Liability account.
		 */
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
//		clientsBank.setC_Location_ID();

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
	 *         for the client
	 */
	private Map<Integer, MChargeType_BH> addDefaultChargeTypes() {
		List<MChargeType_BH> defaultChargeTypes = new Query(context, MChargeType_BH.Table_Name,
				MChargeType_BH.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
						.setParameters(MClient_BH.CLIENTID_CONFIG).list();

		Map<Integer, MChargeType_BH> defaultChargeTypeToChargeTypeMap = new HashMap<>();
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
			defaultChargeTypeToChargeTypeMap.put(defaultChargeType.get_ID(), chargeType);
		}

		return defaultChargeTypeToChargeTypeMap;
	}

	/**
	 * Add the charges that should be included on a new client by default (pulled
	 * from the default charges table
	 *
	 * @return Whether the charges were added successfully or not
	 */
	public boolean addDefaultCharges() {
		// First, create the default charge types
		Map<Integer, MChargeType_BH> defaultChargeTypeToChargeTypeMap = addDefaultChargeTypes();
		// Get collection of account_element_values mapped on the default charges
		Map<Integer, MElementValue> elementValuesMapping = getAllElementValues();

		if (defaultChargeTypeToChargeTypeMap == null || defaultChargeTypeToChargeTypeMap.isEmpty()) {
			return false;
		}
		// Get all active, default charges from the default client
		List<MCharge_BH> defaultCharges = new Query(context,
				MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
						.setParameters(MClient_BH.CLIENTID_CONFIG).list();

		for (MCharge_BH defaultCharge : defaultCharges) {
			// Create a new charge for new client based on this default charge
			MCharge_BH charge = new MCharge_BH(context, 0, getTransactionName());
			charge.setName(defaultCharge.getName());
			charge.setDescription(defaultCharge.getDescription());
			charge.setC_ChargeType_ID(defaultChargeTypeToChargeTypeMap.get(defaultCharge.getC_ChargeType_ID()).get_ID());
			charge.setBH_Locked(defaultCharge.isBH_Locked());
			charge.setBH_SubType(defaultCharge.getBH_SubType());
			charge.setC_ElementValue_ID(defaultCharge.getC_ElementValue_ID());
			charge.setBH_NeedAdditionalVisitInfo(defaultCharge.isBH_NeedAdditionalVisitInfo());
			if (!charge.save()) {
				String errorMessage = "Default Charge NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}

			// Create a valid combination for this account value
			MAccount chargeExpenseAccount = getOrCreateValidCombination(
					elementValuesMapping.get(defaultCharge.getC_ElementValue_ID()).getValue());
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
							.setParameters(defaultCharge.getC_Charge_ID()).first();
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
		if (!addChargeInformation()) {
			return false;
		}
		return true;
	}

	/**
	 * Add non-Patient payments for this client
	 */
	private boolean addChargeInformation() {
		List<MBHChargeInfo> defaultchargeInfoList = new Query(context, MBHChargeInfo.Table_Name,
				MBHChargeInfo.COLUMNNAME_AD_Client_ID + "=?", getTransactionName()).setOnlyActiveRecords(true)
						.setParameters(MClient_BH.CLIENTID_CONFIG).list();

		Map<Integer, MBHChargeInfo> defaultChargeInfoMap = new HashMap<>();
		for (MBHChargeInfo defaultChargeInfo : defaultchargeInfoList) {
			if (!defaultChargeInfo.save()) {
				String errorMessage = "Default Charge Info NOT inserted";
				log.log(Level.SEVERE, errorMessage);
				info.append(errorMessage);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// get the info-values for this entry and save them as well
			List<MBHChargeInfoValue> defaultchargeInfoValuesList = new Query(context, MBHChargeInfoValue.Table_Name,
					MBHChargeInfoValue.COLUMNNAME_BH_Charge_Info_ID + "=?", getTransactionName())
							.setOnlyActiveRecords(true).setParameters(MClient_BH.CLIENTID_CONFIG).list();
			if (defaultchargeInfoValuesList.isEmpty())
				continue;
			for (MBHChargeInfoValue value : defaultchargeInfoValuesList) {
				if (!value.save()) {
					String errorMessage = "ChargeInfo value NOT saved";
					log.log(Level.SEVERE, errorMessage);
					info.append(errorMessage);
					transaction.rollback();
					transaction.close();
					return false;

				}
			}
			defaultChargeInfoMap.put(defaultChargeInfo.get_ID(), defaultChargeInfo);
		}
		return true;
	}

	/**
	 * These creates the default product categories for a client
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
		MRefList userRoleReferenceList = new Query(Env.getCtx(), MRefList.Table_Name,
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

		MRole userRole = new Query(Env.getCtx(), MRole.Table_Name, MRole.COLUMNNAME_Name + "=?", getTransactionName())
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

		MReference userType = new Query(Env.getCtx(), MReference_BH.Table_Name,
				MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", getTransactionName())
						.setParameters(MReference_BH.USER_TYPE_AD_REFERENCE_UU).first();
		if (userType == null) {
			log.log(Level.SEVERE, "User type reference not defined");
			return false;
		}

		List<MRefList> userTypeValues = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?", getTransactionName())
						.setParameters(userType.getAD_Reference_ID()).list();

		if (!createAdditionalRoles(userTypeValues, usersToAddRolesTo)) {
			log.log(Level.SEVERE, "Error creating additional roles");
			return false;
		}

		// Ensure all the roles are present from this point forward
		// Get the roles for this client
		List<MRole> clientRoles = new Query(context, MRole.Table_Name, MRole.COLUMNNAME_AD_Client_ID + "=?",
				getTransactionName()).setParameters(getAD_Client_ID()).list();
		Map<MRefList, MRole> rolesToConfigureByDBUserType = userTypeValues.stream().collect(HashMap::new,
				(rolesToConfigureByDBUserTypeTemp, userTypeValue) -> rolesToConfigureByDBUserTypeTemp.put(userTypeValue,
						clientRoles.stream()
								.filter(clientRole -> clientRole.getName()
										.equals(MBandaSetup.getRoleName(client.getName(), userTypeValue.getName())))
								.findFirst().orElse(null)),
				HashMap::putAll);

		// Ensure all the roles are present
		AtomicBoolean areAllRolesPresent = new AtomicBoolean(true);
		rolesToConfigureByDBUserType.forEach((key, value) -> {
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

		return updateRoles(rolesToConfigureByDBUserType);
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
	 *         applied
	 */
	private boolean handleDocumentActionAccess(Map<MRefList, MRole> rolesToConfigureByDBUserType) {
		// Pull the document action access exclusion values
		List<MBHDefaultDocActionAccess> defaultDocActionAccess = new Query(context,
				MBHDefaultDocActionAccess.Table_Name, null, getTransactionName()).setOnlyActiveRecords(true).list();

		// We need to get a map of the default doc action exclusion IDs (which are for
		// System) and map them to the ones
		// assigned to this client
//		PO.setCrossTenantSafe(); // we need to do a cross-tenant query here, so enable that // <- uncomment for
//		iDempiere-8.2+
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
//		PO.clearCrossTenantSafe(); // disable what was done previously // <- uncomment for iDempiere-8.2+

		// Get all access for the roles we'll configure
		List<X_AD_Document_Action_Access> currentAccessForRolesToConfigure = new Query(Env.getCtx(),
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
		// Add the new roles
		userTypeSuffixes.forEach(userTypeSuffix -> {
			String suffix = userTypeSuffix.getName();
			String name = MBandaSetup.getRoleName(client.getName(), suffix);
			if (!createRole(name, usersToAddRolesTo, new ArrayList<>() {
				{
					add(organization);
				}
			})) {
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
	 * Get a mapping of all charges and related c_elementvalue_id
	 * 
	 * @return map of charge_element_value
	 */
	private Map<Integer, MElementValue> getAllElementValues() {
		Map<Integer, MElementValue> elementValues = new HashMap<>();
		List<MElementValue> accountElementValues = new Query(context, MElementValue.Table_Name,
				MElementValue.COLUMNNAME_AD_Client_ID + "=?",
				getTransactionName()).setParameters(MClient_BH.CLIENTID_CONFIG).list();
		for (MElementValue elementValue : accountElementValues) {
			elementValues.put(elementValue.get_ID(), elementValue);
		}

		return elementValues;
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
		return infoToReturn;
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
