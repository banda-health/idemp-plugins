package org.bandahealth.idempiere.rest;

public interface IRestConfigs {

	String AUTHENTICATION = "auth";
	String AUTHENTICATION_PATH = "/auth";

	String AUTHENTICATION_SESSION_PATH = "/session";
	String TERMSOFSERVICE_PATH = AUTHENTICATION_SESSION_PATH + "/terms-of-service";
	String CHANGEPASSWORD_PATH = AUTHENTICATION_SESSION_PATH + "/change-password";
	String CHANGEACCESS_PATH = AUTHENTICATION_SESSION_PATH + "/change-access";
	String LOGIN_CHECK_PATH = AUTHENTICATION_SESSION_PATH + "/login/check";

	String UUID_PATH = "/{uuid}";

	String MENUS_PATH = AUTHENTICATION_PATH + "/menus";

	String PROCESS_PATH = AUTHENTICATION_PATH + "/processes";
	String RUN_AND_EXPORT_PATH = "/run-and-export";

	String PRODUCTS_PATH = AUTHENTICATION_PATH + "/products";
	String SEARCH_ITEMS_PATH = "/search/items";

	// 'services' used by iDemp WebServices.
	String SERVICES_PATH = AUTHENTICATION_PATH + "/bh-services";

	String PRODUCT_CATEGORIES_PATH = AUTHENTICATION_PATH + "/product-categories";

	String VISITS_PATH = AUTHENTICATION_PATH + "/visits";
	String VISIT_QUEUE_PATH = "/queue";
	String VISIT_OPEN_DRAFTS = "/open-drafts";
	String VISIT_OPEN_DRAFTS_COUNT = VISIT_OPEN_DRAFTS + "/count";

	String PAYMENTS_PATH = AUTHENTICATION_PATH + "/payments";

	String METADATA_PATH = AUTHENTICATION_PATH + "/metadata";

	String ACCOUNTS_PATH = AUTHENTICATION_PATH + "/accounts";

	String USERS_PATH = AUTHENTICATION_PATH + "/users";
	String CLINICIANS_PATH = "/clinicians";
	String NON_ADMINS_PATH = "/non-admins";

	String APPLICATION_PDF = "application/pdf";

	String REFERENCE_LISTS_PATH = AUTHENTICATION_PATH + "/reference-lists";
	String LANGUAGES_PATH = AUTHENTICATION_PATH + "/languages";

	String CODED_DIAGNOSES_PATH = AUTHENTICATION_PATH + "/coded-diagnoses";

	String CHARGES = "/charges";
	String CHARGE_PATH = AUTHENTICATION_PATH + "/charges";
	String PAYER_INFORMATION_LIST = "/payer-information-list";
	String PAYER_INFORMATION_FIELD_SUGGESTION_PATH = AUTHENTICATION_PATH + "/payer-information-field-suggestions";

	String BUSINESS_PARTNER_PATH = AUTHENTICATION_PATH + "/business-partners";

	String VOIDED_REASONS_PATH = AUTHENTICATION_PATH + "/voided-reasons";

	String WAREHOUSES_PATH = AUTHENTICATION_PATH + "/warehouses";

	String MOVEMENTS_PATH = AUTHENTICATION_PATH + "/movements";

	String ATTRIBUTE_SET_INSTANCES_PATH = AUTHENTICATION_PATH + "/attribute-set-instances";

	String QUERY_PARAMETER_PAGE = "page";
	String QUERY_PARAMETER_SIZE = "size";
	String QUERY_PARAMETER_SORTING = "sorting";
	String QUERY_PARAMETER_FILTER = "filter";

	String STORAGE_ON_HAND_PATH = AUTHENTICATION_PATH + "/storage-on-hand";

	String CHARGE_TYPES_PATH = AUTHENTICATION_PATH + "/charge-types";

	String ORGANIZATIONS_PATH = AUTHENTICATION_PATH + "/organizations";

	String ENCOUNTER_TYPE_WINDOWS_PATH = AUTHENTICATION_PATH + "/encounter-type-windows";

	String ROLES_PATH = AUTHENTICATION_PATH + "/roles";
}
