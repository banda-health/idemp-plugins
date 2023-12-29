package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
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
import org.compiere.model.MRefList;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_1099Box;
import org.compiere.model.X_C_Greeting;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartnerResolver extends POResolver<MBPartner_BH> implements GraphQLResolver<MBPartner_BH> {



	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public CompletableFuture<MLanguage> AD_Language_L(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Language() <= 0) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.AD_Language_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Language());
	}

	static Map<String, String> BH_GENDER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.BH_GENDER_Female, "c6cae691-2c3f-43e2-beaa-4d80a196bf34");
			put(MBPartner_BH.BH_GENDER_Male, "73c2b736-830b-430e-bc43-571c6372ba22");
		}
	};
	public CompletableFuture<MRefList> bh_gender_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getbh_gender())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_GENDER_UUIDS_BY_VALUE.get(entity.getbh_gender()));
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.C_BP_Group_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningDataLoader.C_Dunning_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_GreetingDataLoader.C_Greeting_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceScheduleDataLoader.C_InvoiceSchedule_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.C_PaymentTerm_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxGroupDataLoader.C_TaxGroup_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_1099BoxDataLoader.C_1099Box_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDefault1099Box_ID());
	}

	static Map<String, String> DELIVERYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.DELIVERYRULE_AfterPayment, "20fd42a7-54c5-4a60-8e1a-4cda5c9856ee");
			put(MBPartner_BH.DELIVERYRULE_Availability, "89125067-1315-434e-a112-2593bb681a9d");
			put(MBPartner_BH.DELIVERYRULE_CompleteLine, "613c2dee-60a6-46ea-8a0a-646cd4a10c61");
			put(MBPartner_BH.DELIVERYRULE_CompleteOrder, "3f011d8d-6d3d-4d12-aa4c-c5adea40b464");
			put(MBPartner_BH.DELIVERYRULE_Force, "3db26d28-62ee-454c-b25b-5abbef460042");
			put(MBPartner_BH.DELIVERYRULE_Manual, "d9b69f78-edb1-4179-a56e-33cbca133673");
		}
	};
	public CompletableFuture<MRefList> DeliveryRule_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DELIVERYRULE_UUIDS_BY_VALUE.get(entity.getDeliveryRule()));
	}

	static Map<String, String> DELIVERYVIARULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.DELIVERYVIARULE_Pickup, "701ff061-98de-431b-b6ab-b14da4987285");
			put(MBPartner_BH.DELIVERYVIARULE_Delivery, "9d1b379c-84b1-43b1-b735-8c7467cb1b1a");
			put(MBPartner_BH.DELIVERYVIARULE_Shipper, "19951c20-3a06-4eb5-a0c2-fc8b27e408a7");
		}
	};
	public CompletableFuture<MRefList> DeliveryViaRule_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryViaRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DELIVERYVIARULE_UUIDS_BY_VALUE.get(entity.getDeliveryViaRule()));
	}

	static Map<String, String> FREIGHTCOSTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.FREIGHTCOSTRULE_FreightIncluded, "82df2976-c23f-43fb-91e9-b2b4ab27063f");
			put(MBPartner_BH.FREIGHTCOSTRULE_FixPrice, "3c97df02-d8ed-4bca-91b2-c4ca115533c4");
			put(MBPartner_BH.FREIGHTCOSTRULE_Calculated, "43e070a0-f583-4b5d-a11c-6e5945a99272");
			put(MBPartner_BH.FREIGHTCOSTRULE_Line, "623c0263-3294-4073-9884-e5cb78edb1bd");
		}
	};
	public CompletableFuture<MRefList> FreightCostRule_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCostRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getInvoice_PrintFormat_ID());
	}

	static Map<String, String> INVOICERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.INVOICERULE_AfterOrderDelivered, "f0b52a34-6ff9-40b0-8668-cb458e21328e");
			put(MBPartner_BH.INVOICERULE_AfterDelivery, "8d21d623-1f99-4510-aec4-6e475d587264");
			put(MBPartner_BH.INVOICERULE_CustomerScheduleAfterDelivery, "f522d449-bea8-42aa-90e7-b5190db85b68");
			put(MBPartner_BH.INVOICERULE_Immediate, "1e030a09-94f2-4bd4-8810-d739aa9f25a6");
		}
	};
	public CompletableFuture<MRefList> InvoiceRule_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(INVOICERULE_UUIDS_BY_VALUE.get(entity.getInvoiceRule()));
	}


	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	public CompletableFuture<MImage> AD_Image(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (entity.getLogo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.AD_Image_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.M_DiscountSchema_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.M_PriceList_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_PriceList_ID());
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.PAYMENTRULE_Cash, "917130e3-2144-496c-9344-6cf4f7136293");
			put(MBPartner_BH.PAYMENTRULE_CreditCard, "68dda00d-c015-498e-b91c-811bab809dab");
			put(MBPartner_BH.PAYMENTRULE_DirectDeposit, "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put(MBPartner_BH.PAYMENTRULE_Check, "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put(MBPartner_BH.PAYMENTRULE_OnCredit, "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put(MBPartner_BH.PAYMENTRULE_DirectDebit, "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put(MBPartner_BH.PAYMENTRULE_MixedPOSPayment, "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put(MBPartner_BH.PAYMENTRULE_MobileAccount, "c524815a-e048-4052-bab5-b7812e27cd64");
			put(MBPartner_BH.PAYMENTRULE_CashDrawer, "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList> PaymentRule_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	static Map<String, String> PAYMENTRULEPO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.PAYMENTRULEPO_Cash, "917130e3-2144-496c-9344-6cf4f7136293");
			put(MBPartner_BH.PAYMENTRULEPO_CreditCard, "68dda00d-c015-498e-b91c-811bab809dab");
			put(MBPartner_BH.PAYMENTRULEPO_DirectDeposit, "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put(MBPartner_BH.PAYMENTRULEPO_Check, "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put(MBPartner_BH.PAYMENTRULEPO_OnCredit, "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put(MBPartner_BH.PAYMENTRULEPO_DirectDebit, "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put(MBPartner_BH.PAYMENTRULEPO_MixedPOSPayment, "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put(MBPartner_BH.PAYMENTRULEPO_MobileAccount, "c524815a-e048-4052-bab5-b7812e27cd64");
			put(MBPartner_BH.PAYMENTRULEPO_CashDrawer, "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList> PaymentRulePO_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRulePO())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.M_DiscountSchema_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.C_PaymentTerm_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.M_PriceList_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	static Map<String, String> SOCREDITSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBPartner_BH.SOCREDITSTATUS_CreditStop, "ebd6f716-efbe-4a4f-9d3a-e3848f4a3b75");
			put(MBPartner_BH.SOCREDITSTATUS_CreditHold, "5801b69d-7f76-4cfc-98ea-5d5f8e1a9279");
			put(MBPartner_BH.SOCREDITSTATUS_CreditWatch, "562a254f-6346-4cc3-95a6-130edbe6dccc");
			put(MBPartner_BH.SOCREDITSTATUS_NoCreditCheck, "ce7efb85-ccc7-403d-b42f-e276bd9f2f06");
			put(MBPartner_BH.SOCREDITSTATUS_CreditOK, "d2130138-c9f1-4314-a0c3-e46cecaae025");
		}
	};
	public CompletableFuture<MRefList> SOCreditStatus_RL(MBPartner_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSOCreditStatus())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(SOCREDITSTATUS_UUIDS_BY_VALUE.get(entity.getSOCreditStatus()));
	}

}
