package org.bandahealth.idempiere.base.model;

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
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Document_Action_Access;
import org.compiere.model.X_C_BankAccount_Acct;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
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
	private final int clientId;
	private final int orgId;
	private final MAcctSchema accountSchema;
	private final String BANK_DEFAULT_ROUTING_NUMBER = "DefaultRouteNo";
	private final String SUFFIX_TRANSACTION_NAME = "_createClient_BH";
	private final String SUFFIX_BANK_NAME = " Bank";
	private final String SUFFIX_BANK_ACCOUNT_NAME = " Account";
	private final String SUFFIX_BANK_ACCOUNT_NUMBER = "AccountNo";
	protected CLogger log = CLogger.getCLogger(getClass());
	private StringBuffer info;

	public MBandaSetup(Properties ctx, String clientName, String orgName) {
		this.context = ctx;
		language = Env.getAD_Language(this.context);
		this.clientName = clientName;

		clientId = new Query(
				this.context,
				MClient.Table_Name,
				MClient.COLUMNNAME_Name + "=?",
				transaction.getTrxName()
		)
				.setParameters(clientName)
				.firstId();
		orgId = new Query(
				this.context,
				MOrg.Table_Name,
				MOrg.COLUMNNAME_Name + "=? AND " + MOrg.COLUMNNAME_AD_Client_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(orgName, clientId)
				.firstId();

		// For some reason, the client ID isn't set. Set it so entity creation doesn't error out
		Env.setContext(this.context, Env.AD_CLIENT_ID, clientId);

		accountSchema = new Query(
				this.context,
				MAcctSchema.Table_Name,
				MAcctSchema.COLUMNNAME_AD_Client_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(clientId)
				.first();
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
		info = new StringBuffer();

		MAcctSchemaDefault acctSchemaDefault = new Query(
				context,
				MAcctSchemaDefault.Table_Name,
				MAcctSchemaDefault.COLUMNNAME_AD_Client_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(clientId)
				.first();
		if (acctSchemaDefault == null) {
			log.severe("No Accounting Schema Defaults for client");
			transaction.rollback();
			transaction.close();
			return false;
		}

		/**
		 * In iDempiere, accounts are mapped to many different things, such as bank accounts and charges.
		 * The default account mappings generated map different accounts to the Bank Asset account (B_Asset)
		 * and the Bank In-Transit account (B_InTransit). Based on a recommendation from Chuck, we simplify
		 * this mapping and choose to map these accounts to the same default account because we don't ever
		 * upload bank statements, which is the default way iDempiere transfers value from B_InTransit
		 * to B_Asset. So, we need to make the B_Asset account match the B_InTransit account.
		 */
		MAccount assetAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_Asset_Acct(), transaction.getTrxName());
		MAccount inTransitAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_InTransit_Acct(), transaction.getTrxName());
		if (assetAccount == null || inTransitAccount == null) {
			String err = "B_Asset and/or B_InTransit accounts do not exist";
			log.log(Level.SEVERE, err);
			info.append(err);
			transaction.rollback();
			transaction.close();
			return false;
		}
		assetAccount.setAccount_ID(inTransitAccount.getAccount_ID());
		assetAccount.setValueDescription();
		if (!assetAccount.save()) {
			String err = "B_Asset account NOT updated";
			log.log(Level.SEVERE, err);
			info.append(err);
			transaction.rollback();
			transaction.close();
			return false;
		}

		/**
		 * The default account mappings generated map different accounts to the Vendor Liability account (V_Liability)
		 * and the Bank Payment Select account (B_PaymentSelect). Based on a recommendation from Chuck, we simplify
		 * this mapping and choose to map these accounts to the same default account. So, we need to make the
		 * B_PaymentSelect account match the V_Liability account.
		 */
		MAccount paymentSelectAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getB_PaymentSelect_Acct(), transaction.getTrxName());
		MAccount liabilityAccount = (MAccount) MTable.get(context, MAccount.Table_ID)
				.getPO(acctSchemaDefault.getV_Liability_Acct(), transaction.getTrxName());
		if (paymentSelectAccount == null || liabilityAccount == null) {
			String err = "B_PaymentSelect and/or V_Liability accounts do not exist";
			log.log(Level.SEVERE, err);
			info.append(err);
			transaction.rollback();
			transaction.close();
			return false;
		}
		paymentSelectAccount.setAccount_ID(liabilityAccount.getAccount_ID());
		paymentSelectAccount.setValueDescription();
		if (!paymentSelectAccount.save()) {
			String err = "B_PaymentSelect account NOT updated";
			log.log(Level.SEVERE, err);
			info.append(err);
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
		info = new StringBuffer();

		MClient client = (MClient) MTable.get(context, MClient.Table_ID).getPO(clientId, transaction.getTrxName());

		String clientName = client.getName();

		MBank clientsBank = new MBank(context, 0, transaction.getTrxName());
		clientsBank.setName(clientName + SUFFIX_BANK_NAME);
		clientsBank.setDescription(clientsBank.getName());
		clientsBank.setRoutingNo(BANK_DEFAULT_ROUTING_NUMBER);

		clientsBank.setIsOwnBank(true);
		clientsBank.setIsActive(true);
		// Don't need to set location at this point
//		clientsBank.setC_Location_ID();

		if (!clientsBank.save()) {
			String err = "Bank NOT inserted";
			log.log(Level.SEVERE, err);
			info.append(err);
			transaction.rollback();
			transaction.close();
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
		MChargeType_BH defaultCategory = new MChargeType_BH(context, 0, transaction.getTrxName());
		defaultCategory.setName(MChargeType_BH.CHARGETYPENAME_DEFAULT_CATEGORY);
		if (!defaultCategory.save()) {
			String err = "Default Category Charge Type NOT inserted";
			log.log(Level.SEVERE, err);
			info.append(err);
			transaction.rollback();
			transaction.close();
			return false;
		}

		// Get all active, default charges from the system
		List<MBHChargeDefault> defaultCharges = new Query(
				context,
				MBHChargeDefault.Table_Name,
				null,
				transaction.getTrxName()
		)
				.setOnlyActiveRecords(true)
				.list();

		for (MBHChargeDefault defaultCharge : defaultCharges) {
			// Create a new charge based on this default charge
			MCharge_BH chargeToAdd = new MCharge_BH(context, 0, transaction.getTrxName());
			chargeToAdd.setName(defaultCharge.getName());
			chargeToAdd.setDescription(defaultCharge.getDescription());
			chargeToAdd.setBH_Locked(true);
			chargeToAdd.setC_ChargeType_ID(defaultCategory.getC_ChargeType_ID());
			if (!chargeToAdd.save()) {
				String err = "Default Charge NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}

			// Create a valid combination for this account value
			MAccount chargeExpenseAccount = getOrCreateValidCombination(defaultCharge.getValue());
			if (chargeExpenseAccount == null) {
				String err = "Default Charge Valid Combination NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Now get the charge's accounting mapping
			X_C_Charge_Acct chargeAccountToModify = new Query(
					context,
					X_C_Charge_Acct.Table_Name,
					X_C_Charge_Acct.COLUMNNAME_C_Charge_ID + "=?",
					transaction.getTrxName()
			)
					.setParameters(chargeToAdd.getC_Charge_ID())
					.first();
			if (chargeAccountToModify == null) {
				String err = "Charge Account does not exist";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Point the charge to our valid combination
			chargeAccountToModify.setCh_Expense_Acct(chargeExpenseAccount.getC_ValidCombination_ID());
			if (!chargeAccountToModify.save()) {
				String err = "Charge Account NOT updated";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}
		}

		return true;
	}

	/**
	 * These creates the default product categories for a client
	 *
	 * @return
	 */
	public boolean createDefaultProductCategories() {
		info = new StringBuffer();

		// Get all active, default product categories from the system
		List<MBHProductCategoryDefault> defaultProductCategories = new Query(
				context,
				MBHProductCategoryDefault.Table_Name,
				null,
				transaction.getTrxName()
		)
				.setOnlyActiveRecords(true)
				.list();

		for (MBHProductCategoryDefault defaultProductCategory : defaultProductCategories) {
			// Create a new product category based on this default product category
			MProductCategory_BH productCategoryToAdd = new MProductCategory_BH(context, 0, transaction.getTrxName());
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
				transaction.rollback();
				transaction.close();
				return false;
			}

			// Create a valid combination for this account value
			MAccount productCategoryAccount = getOrCreateValidCombination(defaultProductCategory.getValue());
			if (productCategoryAccount == null) {
				String err = "Default Product Category Valid Combination NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Now get the product category's accounting mapping
			MProductCategoryAcct productCategoryAccountToModify = new Query(
					context,
					MProductCategoryAcct.Table_Name,
					MProductCategoryAcct.COLUMNNAME_M_Product_Category_ID + "=?",
					transaction.getTrxName()
			)
					.setParameters(productCategoryToAdd.getM_Product_Category_ID())
					.first();
			if (productCategoryAccountToModify == null) {
				String err = "Product Category Account does not exist";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}
			// Point the product category to our valid combination
			productCategoryAccountToModify.setP_Revenue_Acct(productCategoryAccount.getC_ValidCombination_ID());
			if (!productCategoryAccountToModify.save()) {
				String err = "Product Category Account NOT updated";
				log.log(Level.SEVERE, err);
				info.append(err);
				transaction.rollback();
				transaction.close();
				return false;
			}
		}

		return true;
	}

	/**
	 * The roles for admin and user are created by default - add roles for additional ones in the system, then
	 * handle the associated access for all roles.
	 *
	 * @return Whether the creation was successful
	 */
	public boolean initializeRoles(String adminUserName) {
		MReference userType = new Query(Env.getCtx(), MReference_BH.Table_Name,
				MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", transaction.getTrxName())
				.setParameters(MReference_BH.USER_TYPE_AD_REFERENCE_UU).first();
		if (userType == null) {
			log.log(Level.SEVERE, "User type reference not defined");
			return false;
		}

		List<MRefList> userTypeValues = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Reference_ID + "=?", transaction.getTrxName())
				.setParameters(userType.getAD_Reference_ID()).list();

		if (!createAdditionalRoles(userTypeValues, adminUserName)) {
			log.log(Level.SEVERE, "Error creating additional roles");
			return false;
		}

		// Ensure all the roles are present from this point forward
		// Get the roles for this client
		List<MRole> clientRoles = new Query(context, MRole.Table_Name, MRole.COLUMNNAME_AD_Client_ID + "=?",
				transaction.getTrxName())
				.setParameters(clientId)
				.list();
		Map<MRefList, MRole> rolesToConfigure = userTypeValues.stream().collect(HashMap::new, (m, v) -> m.put(v,
				clientRoles.stream().filter(
						cr -> cr.getName().equals(clientName + " " + v.getName())).findFirst().orElse(null)), HashMap::putAll);

		// Ensure all the roles are present
		AtomicBoolean areAllRolesPresent = new AtomicBoolean(true);
		rolesToConfigure.forEach((key, value) -> {
			if (value == null) {
				String err = key + " role does not exist";
				log.log(Level.SEVERE, err);
				info.append(err);
				areAllRolesPresent.set(false);
			}
		});
		if (!areAllRolesPresent.get()) {
			transaction.rollback();
			transaction.close();
			return false;
		}

		if (!addDefaultIncludedRoles(rolesToConfigure)) {
			log.log(Level.SEVERE, "Error adding default included roles");
			return false;
		}

		if (handleDocumentActionAccessExclusions(rolesToConfigure)) {
			log.log(Level.SEVERE, "Error handling default document action access exclusions");
			return false;
		}
		return true;
	}

	/**
	 * Handle removing document action access based on configured exclusion rules, if any.
	 *
	 * @return Whether the document action access exclusions were successfully applied
	 */
	private boolean handleDocumentActionAccessExclusions(Map<MRefList, MRole> rolesToConfigure) {
		// Pull the document action access exclusion values
		List<MBHDefaultDocActionAccessExclude> defaultDocActionAccessExclusions = new Query(context,
				MBHDefaultDocActionAccessExclude.Table_Name, null, transaction.getTrxName())
				.setOnlyActiveRecords(true)
				.list();

		AtomicBoolean didSuccessfullyDeleteAllDocumentAccess = new AtomicBoolean(true);
		rolesToConfigure.forEach((userType, role) -> {
			// Get the exclusions for this role
			defaultDocActionAccessExclusions.stream().filter(
					dae -> dae.getDB_UserType().equals(userType.getValue())).forEach(dae -> {
				X_AD_Document_Action_Access documentActionAccess = new Query(Env.getCtx(),
						X_AD_Document_Action_Access.Table_Name,
						X_AD_Document_Action_Access.COLUMNNAME_AD_Role_ID + "=? AND " +
								X_AD_Document_Action_Access.COLUMNNAME_C_DocType_ID + "=? AND " +
								X_AD_Document_Action_Access.COLUMNNAME_AD_Ref_List_ID + "=?",
						null)
						.setParameters(role.getAD_Role_ID(), dae.getC_DocType_ID(), dae.getAD_Ref_List_ID()).first();
				if (documentActionAccess != null) {
					if (!documentActionAccess.save()) {
						String err =
								"Could not remove document action access for Role, DocType, and RefList: " + role.getAD_Role_ID() +
										"," +
										" " + dae.getC_DocType_ID() + ", " + dae.getAD_Ref_List_ID();
						log.log(Level.SEVERE, err);
						info.append(err);
						didSuccessfullyDeleteAllDocumentAccess.set(false);
					}
				}
			});
		});

		return didSuccessfullyDeleteAllDocumentAccess.get();
	}

	/**
	 * The roles for admin and user are created by default - add ones for additional roles defined in the DB.
	 *
	 * @return Whether the creation was successful
	 */
	private boolean createAdditionalRoles(List<MRefList> userTypeSuffixes, String adminUserName) {
		// Filter out the roles the system adds
		userTypeSuffixes = userTypeSuffixes.stream().filter(
				ut -> !ut.getValue().equals(DB_USERTYPE_User) && !ut.getValue().equals(DB_USERTYPE_Admin)).collect(
				Collectors.toList());
		AtomicBoolean didSuccessfullyAddedAllRoles = new AtomicBoolean(true);
		// Add the new roles
		userTypeSuffixes.forEach(userTypeSuffix -> {
			String suffix = userTypeSuffix.getName();
			String name = clientName + " " + suffix;
			MRole role = new MRole(context, 0, transaction.getTrxName());
			role.setName(name);
			role.setIsAccessAdvanced(false);
			if (!role.save()) {
				String err = suffix + " Role NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
				didSuccessfullyAddedAllRoles.set(false);
			}
			//  OrgAccess x,y
			MRoleOrgAccess userOrgAccess = new MRoleOrgAccess(role, orgId);
			if (!userOrgAccess.save()) {
				log.log(Level.SEVERE, suffix + " Role_OrgAccess NOT created");
			}
			// Update the appropriate users to have access to this new role
			MUser clientAdminUser = new Query(context, MUser.Table_Name,
					MUser_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MUser_BH.COLUMNNAME_Name + "=?",
					transaction.getTrxName())
					.setParameters(clientId, adminUserName)
					.first();
			if (clientAdminUser != null) {
				MUserRoles userRole = new MUserRoles(context, clientAdminUser.getAD_User_ID(), role.getAD_Role_ID(),
						transaction.getTrxName());
				userRole.saveEx();
			}
		});
		return didSuccessfullyAddedAllRoles.get();
	}

	/**
	 * The roles created for a client need to have the Banda Health master roles included. Add the ones configured
	 * in the system to the created roles.
	 *
	 * @return Whether the addition was successful
	 */
	private boolean addDefaultIncludedRoles(Map<MRefList, MRole> rolesToConfigure) {
		// Pull the default role IDs to include
		List<MBHDefaultIncludedRole> defaultIncludedRoles = new Query(context, MBHDefaultIncludedRole.Table_Name,
				null, transaction.getTrxName())
				.setOnlyActiveRecords(true)
				.list();
		int sequencerIncrement = 10;
		Map<Integer, Integer> roleSequencers = rolesToConfigure.values().stream().collect(
				Collectors.toMap(MRole::getAD_Role_ID, v -> sequencerIncrement));
		for (MBHDefaultIncludedRole defaultIncludedRole : defaultIncludedRoles) {
			MRoleIncluded roleIncluded = new MRoleIncluded(context, 0, transaction.getTrxName());
			roleIncluded.setIncluded_Role_ID(defaultIncludedRole.getIncluded_Role_ID());

			Optional<MRole> role = rolesToConfigure.entrySet().stream().filter(
					rtc -> defaultIncludedRole.getDB_UserType().equals(rtc.getKey().getValue())).map(
					Map.Entry::getValue).findFirst();

			if (role.isPresent()) {
				int roleId = role.get().getAD_Role_ID();
				roleIncluded.setAD_Role_ID(roleId);
				int sequencerToUse = roleSequencers.get(roleId);
				roleIncluded.setSeqNo(sequencerToUse);
				roleSequencers.put(roleId, sequencerToUse + sequencerIncrement);
			} else {
				log.log(Level.INFO, "Unknown User Type: " + defaultIncludedRole.getDB_UserType());
			}

			roleIncluded.saveEx();
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
		MReference paymentBankAccountMappingReference = new Query(
				context,
				MReference.Table_Name,
				MReference.COLUMNNAME_AD_Reference_UU + "=?",
				transaction.getTrxName()
		)
				.setParameters(MBandaSetup.REFERENCE_PAYMENT_REF_UU)
				.first();
		if (paymentBankAccountMappingReference == null) {
			log.severe("No Reference in the System for Payment Bank Account Mappings");
			transaction.rollback();
			transaction.close();
			return false;
		}
		MRefTable paymentBankAccountMappingsReferenceLimiting = new Query(
				context,
				MRefTable.Table_Name,
				MRefTable.COLUMNNAME_AD_Reference_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(paymentBankAccountMappingReference.getAD_Reference_ID())
				.first();
		if (paymentBankAccountMappingsReferenceLimiting == null) {
			log.severe("No Reference in the System for Payment Bank Account Mappings");
			transaction.rollback();
			transaction.close();
			return false;
		}

		// So that we don't have to hard code these values, get the ones stored for the screen's dynamic validation
		List<MReference> referencesToCreatePaymentMappingsFor = new Query(
				context,
				MReference.Table_Name,
				paymentBankAccountMappingsReferenceLimiting.getWhereClause(),
				transaction.getTrxName()
		)
				.list();
		if (referencesToCreatePaymentMappingsFor == null) {
			referencesToCreatePaymentMappingsFor = new ArrayList<MReference>();
		}
		for (MReference referenceToCreatePaymentMappingsFor : referencesToCreatePaymentMappingsFor) {
			MBHPaymentRef paymentRef = new MBHPaymentRef(context, 0, transaction.getTrxName());
			paymentRef.setAD_Org_ID(orgId);
			paymentRef.setAD_Reference_ID(referenceToCreatePaymentMappingsFor.getAD_Reference_ID());
			if (!paymentRef.save()) {
				String err = "Payment Bank Account mapping NOT inserted";
				log.log(Level.SEVERE, err);
				info.append(err);
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
	private boolean createAndSaveBankAccount(String clientName, String accountName, boolean isDefault,
			int bankId, String inTransitAccountValue) {
		MBankAccount bankAccount = new MBankAccount(context, 0, transaction.getTrxName());
		bankAccount.setIsActive(true);
		bankAccount.setIsDefault(isDefault);
		bankAccount.setName(clientName + " " + accountName + SUFFIX_BANK_ACCOUNT_NAME);
		bankAccount.setAD_Org_ID(orgId);
		bankAccount.setC_Bank_ID(bankId);
		bankAccount.setAccountNo(accountName + SUFFIX_BANK_ACCOUNT_NUMBER);
		bankAccount.setC_Currency_ID(accountSchema.getC_Currency_ID());
		bankAccount.setBankAccountType(MBankAccount.BANKACCOUNTTYPE_Cash);

		if (!bankAccount.save()) {
			String err = accountName + " Bank Account NOT inserted";
			log.log(Level.SEVERE, err);
			info.append(err);
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
		X_C_BankAccount_Acct accountMapping = new Query(
				context,
				X_C_BankAccount_Acct.Table_Name,
				X_C_BankAccount_Acct.COLUMNNAME_C_BankAccount_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(bankAccount.getC_BankAccount_ID())
				.first();
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
			String err = "Account Mapping NOT updated";
			log.log(Level.SEVERE, err);
			info.append(err);
			transaction.rollback();
			transaction.close();
			return false;
		}

		return true;
	}

	/**
	 * Get the valid combination for an account or create one if none currently exists and return it.
	 *
	 * @param accountValue
	 * @return
	 */
	private MAccount getOrCreateValidCombination(String accountValue) {
		MElementValue accountElement = new Query(
				context,
				MElementValue.Table_Name,
				MElementValue.COLUMNNAME_Value + "=? AND " + MElementValue.COLUMNNAME_AD_Client_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(accountValue, clientId)
				.first();
		if (accountElement == null) {
			return null;
		}
		// See if an account already exists for this account value
		MAccount account = new Query(
				context,
				MAccount.Table_Name,
				MAccount.COLUMNNAME_AD_Client_ID + "=? AND " + MAccount.COLUMNNAME_Account_ID + "=?",
				transaction.getTrxName()
		)
				.setParameters(accountElement.getAD_Client_ID(), accountElement.getC_ElementValue_ID())
				.first();
		if (account != null) {
			return account;
		}

		account = new MAccount(context, 0, transaction.getTrxName());
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
	 * Get Client
	 *
	 * @return AD_Client_ID
	 */
	public int getAD_Client_ID() {
		return clientId;
	}

	/**
	 * Get AD_Org_ID
	 *
	 * @return AD_Org_ID
	 */
	public int getAD_Org_ID() {
		return orgId;
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
	 * Rollback Internal Transaction
	 */
	public void rollback() {
		try {
			transaction.rollback();
			transaction.close();
		} catch (Exception e) {
		}
	}
}
