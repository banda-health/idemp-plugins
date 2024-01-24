package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_1099BoxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_GreetingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MImage;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MLanguage;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_1099Box;
import org.compiere.model.X_C_Greeting;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxGroup;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BPartnerResolver extends POResolver<MBPartner_BH> implements GraphQLResolver<MBPartner_BH> {


	static Map<String, Integer> AD_LANGUAGE_IDS_BY_LANGUAGE = new HashMap<>() {
		{
			put("ar_AE", 100);
			put("ar_BH", 101);
			put("ar_DZ", 102);
			put("ar_EG", 103);
			put("ar_IQ", 104);
			put("ar_JO", 105);
			put("ar_KW", 106);
			put("ar_LB", 107);
			put("ar_LY", 108);
			put("ar_MA", 109);
			put("ar_OM", 110);
			put("ar_QA", 111);
			put("ar_SA", 112);
			put("ar_SD", 113);
			put("ar_SY", 114);
			put("ar_TN", 115);
			put("ar_YE", 116);
			put("be_BY", 117);
			put("bg_BG", 118);
			put("ca_ES", 119);
			put("cs_CZ", 120);
			put("da_DK", 121);
			put("de_AT", 122);
			put("de_CH", 123);
			put("de_DE", 191);
			put("de_LU", 124);
			put("el_CY", 50004);
			put("el_GR", 125);
			put("en_AU", 126);
			put("en_CA", 127);
			put("en_GB", 128);
			put("en_IE", 129);
			put("en_IN", 130);
			put("en_KE", 50017);
			put("en_MT", 50005);
			put("en_NZ", 131);
			put("en_PH", 50006);
			put("en_SG", 50007);
			put("en_US", 192);
			put("en_ZA", 132);
			put("es_AR", 133);
			put("es_BO", 134);
			put("es_CL", 135);
			put("es_CO", 136);
			put("es_CR", 137);
			put("es_DO", 138);
			put("es_EC", 139);
			put("es_ES", 140);
			put("es_GT", 141);
			put("es_HN", 142);
			put("es_MX", 143);
			put("es_NI", 144);
			put("es_PA", 145);
			put("es_PE", 146);
			put("es_PR", 147);
			put("es_PY", 148);
			put("es_SV", 149);
			put("es_US", 50008);
			put("es_UY", 150);
			put("es_VE", 151);
			put("et_EE", 152);
			put("fa_IR", 193);
			put("fi_FI", 153);
			put("fr_BE", 154);
			put("fr_CA", 155);
			put("fr_CH", 156);
			put("fr_FR", 190);
			put("fr_LU", 157);
			put("ga_IE", 50009);
			put("hi_IN", 158);
			put("hr_HR", 159);
			put("hu_HU", 160);
			put("in_ID", 50010);
			put("is_IS", 161);
			put("it_CH", 162);
			put("it_IT", 163);
			put("iw_IL", 164);
			put("ja_JP", 165);
			put("ko_KR", 166);
			put("lt_LT", 167);
			put("lv_LV", 168);
			put("mk_MK", 169);
			put("ms_MY", 50003);
			put("mt_MT", 50011);
			put("nl_BE", 170);
			put("nl_NL", 171);
			put("no_NO", 172);
			put("pl_PL", 173);
			put("pt_BR", 174);
			put("pt_PT", 175);
			put("ro_RO", 176);
			put("ru_RU", 177);
			put("sh_YU", 178);
			put("sk_SK", 179);
			put("sl_SI", 180);
			put("sq_AL", 181);
			put("sr_BA", 50012);
			put("sr_CS", 50013);
			put("sr_ME", 50014);
			put("sr_RS", 50015);
			put("sr_YU", 182);
			put("sv_SE", 183);
			put("th_TH", 184);
			put("tr_TR", 185);
			put("uk_UA", 186);
			put("vi_VN", 194);
			put("zh_CN", 187);
			put("zh_HK", 188);
			put("zh_SG", 50016);
			put("zh_TW", 189);
		}
	};

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public CompletableFuture<MLanguage> AD_Language(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_Language())) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.DATALOADER_AD_Language_BY_ID);
		return dataLoader.load(AD_LANGUAGE_IDS_BY_LANGUAGE.get(entity.getAD_Language()));
	}

	static Map<String, String> BH_GENDER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("female", "c6cae691-2c3f-43e2-beaa-4d80a196bf34");
			put("male", "73c2b736-830b-430e-bc43-571c6372ba22");
		}
	};
	public CompletableFuture<MRefList_BH> bh_gender(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getbh_gender())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_GENDER_UUIDS_BY_VALUE.get(entity.getbh_gender()));
	}

	public Boolean BH_IsApproximateDateOfBirth(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsApproximateDateOfBirth();
	}

	public Boolean BH_Locked(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_Locked();
	}

	public Boolean BH_NeedAdditionalVisitInfo(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_NeedAdditionalVisitInfo();
	}

	public Timestamp bh_nextappointmentdate(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.getbh_nextappointmentdate();
	}

	public String bh_occupation(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.getbh_occupation();
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public CompletableFuture<MDunning> C_Dunning(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Dunning_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningDataLoader.DATALOADER_C_Dunning_BY_ID);
		return dataLoader.load(entity.getC_Dunning_ID());
	}


	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	public CompletableFuture<X_C_Greeting> C_Greeting(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Greeting_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Greeting> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_GreetingDataLoader.DATALOADER_C_Greeting_BY_ID);
		return dataLoader.load(entity.getC_Greeting_ID());
	}


	/**
	 * Get Invoice Schedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	public CompletableFuture<MInvoiceSchedule> C_InvoiceSchedule(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceSchedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceScheduleDataLoader.DATALOADER_C_InvoiceSchedule_BY_ID);
		return dataLoader.load(entity.getC_InvoiceSchedule_ID());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}


	/**
	 * Get Tax Group.
	 *
	 * @return Tax Group
	 */
	public CompletableFuture<X_C_TaxGroup> C_TaxGroup(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxGroup_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_TaxGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxGroupDataLoader.DATALOADER_C_TaxGroup_BY_ID);
		return dataLoader.load(entity.getC_TaxGroup_ID());
	}


	/**
	 * Get Default 1099 Box.
	 *
	 * @return Default 1099 Box
	 */
	public CompletableFuture<X_C_1099Box> Default1099Box(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDefault1099Box_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_1099Box> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_1099BoxDataLoader.DATALOADER_C_1099Box_BY_ID);
		return dataLoader.load(entity.getDefault1099Box_ID());
	}

	static Map<String, String> DELIVERYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "20fd42a7-54c5-4a60-8e1a-4cda5c9856ee");
			put("A", "89125067-1315-434e-a112-2593bb681a9d");
			put("L", "613c2dee-60a6-46ea-8a0a-646cd4a10c61");
			put("O", "3f011d8d-6d3d-4d12-aa4c-c5adea40b464");
			put("F", "3db26d28-62ee-454c-b25b-5abbef460042");
			put("M", "d9b69f78-edb1-4179-a56e-33cbca133673");
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryRule(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYRULE_UUIDS_BY_VALUE.get(entity.getDeliveryRule()));
	}

	static Map<String, String> DELIVERYVIARULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "701ff061-98de-431b-b6ab-b14da4987285");
			put("D", "9d1b379c-84b1-43b1-b735-8c7467cb1b1a");
			put("S", "19951c20-3a06-4eb5-a0c2-fc8b27e408a7");
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryViaRule(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryViaRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYVIARULE_UUIDS_BY_VALUE.get(entity.getDeliveryViaRule()));
	}

	static Map<String, String> FREIGHTCOSTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "82df2976-c23f-43fb-91e9-b2b4ab27063f");
			put("F", "3c97df02-d8ed-4bca-91b2-c4ca115533c4");
			put("C", "43e070a0-f583-4b5d-a11c-6e5945a99272");
			put("L", "623c0263-3294-4073-9884-e5cb78edb1bd");
		}
	};
	public CompletableFuture<MRefList_BH> FreightCostRule(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCostRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREIGHTCOSTRULE_UUIDS_BY_VALUE.get(entity.getFreightCostRule()));
	}


	/**
	 * Get Invoice Print Format.
	 *
	 * @return Print Format for printing Invoices
	 */
	public CompletableFuture<X_AD_PrintFormat> Invoice_PrintFormat(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getInvoice_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getInvoice_PrintFormat_ID());
	}

	static Map<String, String> INVOICERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("O", "f0b52a34-6ff9-40b0-8668-cb458e21328e");
			put("D", "8d21d623-1f99-4510-aec4-6e475d587264");
			put("S", "f522d449-bea8-42aa-90e7-b5190db85b68");
			put("I", "1e030a09-94f2-4bd4-8810-d739aa9f25a6");
		}
	};
	public CompletableFuture<MRefList_BH> InvoiceRule(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(INVOICERULE_UUIDS_BY_VALUE.get(entity.getInvoiceRule()));
	}

	public Boolean Is1099Vendor(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.is1099Vendor();
	}

	public Boolean IsCustomer(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isCustomer();
	}

	public Boolean IsDiscountPrinted(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isDiscountPrinted();
	}

	public Boolean IsEmployee(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isEmployee();
	}

	public Boolean IsManufacturer(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isManufacturer();
	}

	public Boolean IsOneTime(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isOneTime();
	}

	public Boolean IsPOTaxExempt(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isPOTaxExempt();
	}

	public Boolean IsProspect(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isProspect();
	}

	public Boolean IsSalesRep(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isSalesRep();
	}

	public Boolean IsSummary(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	public Boolean IsTaxExempt(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isTaxExempt();
	}

	public Boolean IsVendor(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isVendor();
	}


	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	public CompletableFuture<MImage> Logo(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getLogo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getLogo_ID());
	}


	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> M_DiscountSchema(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_DiscountSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getM_DiscountSchema_ID());
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	static Map<String, String> PAYMENTRULEPO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRulePO(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRulePO())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULEPO_UUIDS_BY_VALUE.get(entity.getPaymentRulePO()));
	}


	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> PO_DiscountSchema(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPO_DiscountSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getPO_DiscountSchema_ID());
	}


	/**
	 * Get PO Payment Term.
	 *
	 * @return Payment rules for a purchase order
	 */
	public CompletableFuture<MPaymentTerm> PO_PaymentTerm(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPO_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getPO_PaymentTerm_ID());
	}


	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	public CompletableFuture<MPriceList> PO_PriceList(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPO_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getPO_PriceList_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	public Boolean SendEMail(MBPartner_BH entity, DataFetchingEnvironment environment) {
		return entity.isSendEMail();
	}

	static Map<String, String> SOCREDITSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "ebd6f716-efbe-4a4f-9d3a-e3848f4a3b75");
			put("H", "5801b69d-7f76-4cfc-98ea-5d5f8e1a9279");
			put("W", "562a254f-6346-4cc3-95a6-130edbe6dccc");
			put("X", "ce7efb85-ccc7-403d-b42f-e276bd9f2f06");
			put("O", "d2130138-c9f1-4314-a0c3-e46cecaae025");
		}
	};
	public CompletableFuture<MRefList_BH> SOCreditStatus(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSOCreditStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SOCREDITSTATUS_UUIDS_BY_VALUE.get(entity.getSOCreditStatus()));
	}

}
