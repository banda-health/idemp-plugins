package org.bandahealth.idempiere.rest;

public interface IRestConfigs {

	String ROOT_PATH = "/";
	String AUTHENTICATION = "auth";
	String AUTHENTICATION_PATH = ROOT_PATH + AUTHENTICATION;

	String AUTHENTICATION_SESSION_PATH = "/session";
	String TERMSOFSERVICE_PATH = AUTHENTICATION_SESSION_PATH + "/terms";
	String CHANGEPASSWORD_PATH = AUTHENTICATION_SESSION_PATH + "/changePassword";
	String CHANGEACCESS_PATH = AUTHENTICATION_SESSION_PATH + "/changeAccess";

	String SAVE_PATH = "/save";

	String SEARCH_PATH = "/search";

	String UUID_PATH = "/{uuid}";

	String PRINT_RECEIPT_PATH = UUID_PATH + "/printreceipt";

	String PATIENTS_PATH = AUTHENTICATION_PATH + "/patients";
	String PATIENT_PATH = "/patient/{uuid}";
	String PATIENT_SUMMARY_PATH = AUTHENTICATION_PATH + "/patientsummary";
	String PATIENT_GENERATE_ID = "/generatepatientid";

	String VENDORS_PATH = AUTHENTICATION_PATH + "/vendors";
	String VENDOR_PATH = "/vendor/{uuid}";

	String MENUS_PATH = AUTHENTICATION_PATH + "/menus";
	String MENU_PATH = "/menu/{uuid}";

	String PROCESS_PATH = AUTHENTICATION_PATH + "/process";
	String RUN_AND_EXPORT_PATH = "/runandexport";

	String REPORTS_PATH = AUTHENTICATION_PATH + "/reports";
	String GENERATE_PATH = "/generate";

	String PRODUCTS_PATH = AUTHENTICATION_PATH + "/products";
	String PRODUCT_PATH = "/product/{uuid}";
	String SEARCH_ITEMS_PATH = "/searchitems";

	// 'services' used by iDemp WebServices.
	String SERVICES_PATH = AUTHENTICATION_PATH + "/bhservices";
	String SERVICE_PATH = "/service/{uuid}";

	String EXPENSE_CATEGORIES_PATH = AUTHENTICATION_PATH + "/expensecategories";
	String EXPENSE_CATEGORY_PATH = "/expensecategory/{uuid}";

	String PRODUCT_CATEGORIES_PATH = AUTHENTICATION_PATH + "/productcategories";

	String STOCK_TAKE_ITEMS_PATH = AUTHENTICATION_PATH + "/stocktake";
	String STOCK_TAKE_ITEM_PATH = "/stocktake/{uuid}";

	String ENTITY_PROCESS_PATH = "/{uuid}/process/{processType}";
	String ENTITY_SAVE_AND_PROCESS_PATH = "/process/{processType}";

	String VISITS_PATH = AUTHENTICATION_PATH + "/visits";
	String VISIT_QUEUE_PATH = "/visitqueue";
	String VISIT_OPEN_DRAFTS = "/opendrafts";
	String VISIT_OPEN_DRAFTS_COUNT = VISIT_OPEN_DRAFTS + "/count";

	String PAYMENTS_PATH = AUTHENTICATION_PATH + "/payments";

	String METADATA_PATH = AUTHENTICATION_PATH + "/metadata";

	String RECEIVE_PRODUCTS_PATH = AUTHENTICATION_PATH + "/receiveproducts";

	String EXPENSES_PATH = AUTHENTICATION_PATH + "/expenses";

	String ACCOUNTS_PATH = AUTHENTICATION_PATH + "/accounts";
	String ACCOUNTS_UUID_PATH = "/account/{uuid}";

	String USERS_PATH = AUTHENTICATION_PATH + "/users";
	String CLINICIANS_PATH = "/clinicians";
	String NON_ADMINS_PATH = "/nonadmins";

	String APPLICATION_PDF = "application/pdf";

	String REFERENCE_LISTS_PATH = AUTHENTICATION_PATH + "/reference-lists";
	String LANGUAGES_PATH = AUTHENTICATION_PATH + "/languages";
	
	String CODED_DIAGNOSES_PATH = AUTHENTICATION_PATH + "/codeddiagnoses";
	String CODED_DIAGNOSIS_PATH = "/codeddiagnosis/{uuid}";

	String CHARGES = "/charges";
	String CHARGE_PATH = AUTHENTICATION_PATH + "/charges";
	String NON_PATIENT_PAYMENTS_PATH = "/nonpatientpayments";
	String CHARGE_INFORMATION_SUGGESTION_PATH = AUTHENTICATION_PATH + "/chargeInformationSuggestions";

	String BUSINESS_PARTNER_PATH = AUTHENTICATION_PATH + "/businessPartners";
	
	String VOIDED_REASONS_PATH = AUTHENTICATION_PATH + "/voidedreasons";
	
	String WAREHOUSES_PATH = AUTHENTICATION_PATH + "/warehouses";
	String WAREHOUSE_PATH = "/warehouse/{uuid}";
	
	String MOVEMENTS_PATH = AUTHENTICATION_PATH + "/movements";

	String ATTRIBUTE_SET_INSTANCES_PATH = AUTHENTICATION_PATH + "/attribute-set-instances";
	
	String QUERY_PARAMETER_PAGE = "page";
	String QUERY_PARAMETER_SIZE = "size";
	String QUERY_PARAMETER_SORTING = "sorting";
	String QUERY_PARAMETER_FILTER = "filter";
	String QUERY_PARAMETER_VALUE = "value";
	
	String STORAGE_ON_HAND_PATH = AUTHENTICATION_PATH + "/storage-on-hand";
	
	String CHARGE_TYPES_PATH = AUTHENTICATION_PATH + "/charge-types";
}
