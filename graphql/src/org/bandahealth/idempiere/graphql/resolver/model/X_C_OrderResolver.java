package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Voided_ReasonDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashPlanLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OpportunityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderSourceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_FreightCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashLine;
import org.compiere.model.MCashPlanLine;
import org.compiere.model.MConversionType;
import org.compiere.model.MElementValue;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MOpportunity;
import org.compiere.model.MPOS;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MProject;
import org.compiere.model.MShipper;
import org.compiere.model.X_C_OrderSource;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderResolver extends POResolver<MOrder_BH> implements GraphQLResolver<MOrder_BH> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public CompletableFuture<MBHVisit> BH_Visit(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_VisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(entity.getBH_Visit_ID());
	}


	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public CompletableFuture<MBHVoidedReason> BH_Voided_Reason(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Voided_Reason_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHVoidedReason> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Voided_ReasonDataLoader.DATALOADER_BH_Voided_Reason_BY_ID);
		return dataLoader.load(entity.getBH_Voided_Reason_ID());
	}


	/**
	 * Get Invoice Partner.
	 *
	 * @return Business Partner to be invoiced
	 */
	public CompletableFuture<MBPartner_BH> Bill_BPartner(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBill_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getBill_BPartner_ID());
	}


	/**
	 * Get Invoice Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	public CompletableFuture<MBPartnerLocation> Bill_Location(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBill_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getBill_Location_ID());
	}


	/**
	 * Get Invoice Contact.
	 *
	 * @return Business Partner Contact for invoicing
	 */
	public CompletableFuture<MUser_BH> Bill_User(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBill_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getBill_User_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Cash Journal Line.
	 *
	 * @return Cash Journal Line
	 */
	public CompletableFuture<MCashLine> C_CashLine(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCashLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashLineDataLoader.DATALOADER_C_CashLine_BY_ID);
		return dataLoader.load(entity.getC_CashLine_ID());
	}


	/**
	 * Get Cash Plan Line.
	 *
	 * @return Cash Plan Line
	 */
	public CompletableFuture<MCashPlanLine> C_CashPlanLine(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashPlanLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCashPlanLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashPlanLineDataLoader.DATALOADER_C_CashPlanLine_BY_ID);
		return dataLoader.load(entity.getC_CashPlanLine_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionType_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeTarget(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeTarget_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeTarget_ID());
	}


	/**
	 * Get Sales Opportunity.
	 *
	 * @return Sales Opportunity
	 */
	public CompletableFuture<MOpportunity> C_Opportunity(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Opportunity_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOpportunity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OpportunityDataLoader.DATALOADER_C_Opportunity_BY_ID);
		return dataLoader.load(entity.getC_Opportunity_ID());
	}


	/**
	 * Get Order Source.
	 *
	 * @return Order Source
	 */
	public CompletableFuture<X_C_OrderSource> C_OrderSource(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderSource_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_C_OrderSource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderSourceDataLoader.DATALOADER_C_OrderSource_BY_ID);
		return dataLoader.load(entity.getC_OrderSource_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}


	/**
	 * Get POS Terminal.
	 *
	 * @return Point of Sales Terminal
	 */
	public CompletableFuture<MPOS> C_POS(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_POS_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPOS> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSDataLoader.DATALOADER_C_POS_BY_ID);
		return dataLoader.load(entity.getC_POS_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}

	public static Map<String, String> DELIVERYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "20fd42a7-54c5-4a60-8e1a-4cda5c9856ee"); // After Payment
			put("A", "89125067-1315-434e-a112-2593bb681a9d"); // Availability
			put("L", "613c2dee-60a6-46ea-8a0a-646cd4a10c61"); // Complete Line
			put("O", "3f011d8d-6d3d-4d12-aa4c-c5adea40b464"); // Complete Order
			put("F", "3db26d28-62ee-454c-b25b-5abbef460042"); // Force
			put("M", "d9b69f78-edb1-4179-a56e-33cbca133673"); // Manual
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryRule(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYRULE_UUIDS_BY_VALUE.get(entity.getDeliveryRule()));
	}

	public static Map<String, String> DELIVERYVIARULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "701ff061-98de-431b-b6ab-b14da4987285"); // Pickup
			put("D", "9d1b379c-84b1-43b1-b735-8c7467cb1b1a"); // Delivery
			put("S", "19951c20-3a06-4eb5-a0c2-fc8b27e408a7"); // Shipper
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryViaRule(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryViaRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYVIARULE_UUIDS_BY_VALUE.get(entity.getDeliveryViaRule()));
	}

	public static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da"); // Complete
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169"); // Approve
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354"); // Reject
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9"); // Post
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3"); // Void
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0"); // Close
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6"); // Reverse - Correct
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8"); // Reverse - Accrual
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf"); // Invalidate
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260"); // Re-activate
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591"); // <None>
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76"); // Prepare
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5"); // Unlock
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0"); // Wait Complete
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	public static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec"); // Drafted
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204"); // Completed
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5"); // Approved
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2"); // Not Approved
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570"); // Voided
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77"); // Invalid
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6"); // Reversed
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e"); // Closed
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2"); // Unknown
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc"); // In Progress
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9"); // Waiting Payment
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6"); // Waiting Confirmation
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}


	/**
	 * Get Drop Ship Business Partner.
	 *
	 * @return Business Partner to ship to
	 */
	public CompletableFuture<MBPartner_BH> DropShip_BPartner(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getDropShip_BPartner_ID());
	}


	/**
	 * Get Drop Shipment Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	public CompletableFuture<MBPartnerLocation> DropShip_Location(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getDropShip_Location_ID());
	}


	/**
	 * Get Drop Shipment Contact.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	public CompletableFuture<MUser_BH> DropShip_User(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getDropShip_User_ID());
	}

	public static Map<String, String> FREIGHTCOSTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "82df2976-c23f-43fb-91e9-b2b4ab27063f"); // Freight included
			put("F", "3c97df02-d8ed-4bca-91b2-c4ca115533c4"); // Fix price
			put("C", "43e070a0-f583-4b5d-a11c-6e5945a99272"); // Calculated
			put("L", "623c0263-3294-4073-9884-e5cb78edb1bd"); // Line
			put("U", "7ed34a5f-ffe5-499e-afd0-f074cca9d1f6"); // Customer Account
		}
	};
	public CompletableFuture<MRefList_BH> FreightCostRule(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCostRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREIGHTCOSTRULE_UUIDS_BY_VALUE.get(entity.getFreightCostRule()));
	}

	public static Map<String, String> INVOICERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("O", "f0b52a34-6ff9-40b0-8668-cb458e21328e"); // After Order delivered
			put("D", "8d21d623-1f99-4510-aec4-6e475d587264"); // After Delivery
			put("S", "f522d449-bea8-42aa-90e7-b5190db85b68"); // Customer Schedule after Delivery
			put("I", "1e030a09-94f2-4bd4-8810-d739aa9f25a6"); // Immediate
		}
	};
	public CompletableFuture<MRefList_BH> InvoiceRule(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(INVOICERULE_UUIDS_BY_VALUE.get(entity.getInvoiceRule()));
	}

	public Boolean IsApproved(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsCreditApproved(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isCreditApproved();
	}

	public Boolean IsDelivered(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isDelivered();
	}

	public Boolean IsDiscountPrinted(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isDiscountPrinted();
	}

	public Boolean IsDropShip(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isDropShip();
	}

	public Boolean IsInvoiced(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isInvoiced();
	}

	public Boolean IsPayScheduleValid(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isPayScheduleValid();
	}

	public Boolean IsPrinted(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsPriviledgedRate(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isPriviledgedRate();
	}

	public Boolean IsSelected(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isSelected();
	}

	public Boolean IsSelfService(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean IsSOTrx(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}

	public Boolean IsTaxIncluded(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}

	public Boolean IsTransferred(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isTransferred();
	}


	/**
	 * Get Linked Order.
	 *
	 * @return This field links a sales order to the purchase order that is generated from it.
	 */
	public CompletableFuture<MOrder_BH> Link_Order(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getLink_Order_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getLink_Order_ID());
	}


	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	public CompletableFuture<MFreightCategory> M_FreightCategory(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_FreightCategory_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MFreightCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_FreightCategoryDataLoader.DATALOADER_M_FreightCategory_BY_ID);
		return dataLoader.load(entity.getM_FreightCategory_ID());
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	public static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293"); // Cash
			put("K", "68dda00d-c015-498e-b91c-811bab809dab"); // Credit Card
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf"); // Direct Deposit
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e"); // Check
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a"); // On Credit
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e"); // Direct Debit
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb"); // Mixed POS Payment
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64"); // Mobile Account
			put("b", "72629357-494a-4cb3-aecf-807141f1968b"); // Cash Drawer
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	public Boolean Posted(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
	}

	public static Map<String, String> PRIORITYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "eb2a15e0-e10d-47df-9ddd-d12d39b32007"); // High
			put("5", "6ca5bed6-2fd6-4afd-b3a8-d9c91452e829"); // Medium
			put("7", "74703c05-07aa-47d6-8ee3-e884ce2f505e"); // Low
			put("1", "6d26a706-aa9f-4111-8b5b-741aa48476d9"); // Urgent
			put("9", "c349e252-ad91-483f-b53f-0e92fabbaca5"); // Minor
		}
	};
	public CompletableFuture<MRefList_BH> PriorityRule(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriorityRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PRIORITYRULE_UUIDS_BY_VALUE.get(entity.getPriorityRule()));
	}

	public Boolean Processed(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Quotation.
	 *
	 * @return Quotation used for generating this order
	 */
	public CompletableFuture<MOrder_BH> QuotationOrder(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getQuotationOrder_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getQuotationOrder_ID());
	}


	/**
	 * Get Referenced Order.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	public CompletableFuture<MOrder_BH> Ref_Order(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getRef_Order_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getRef_Order_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	public Boolean SendEMail(MOrder_BH entity, DataFetchingEnvironment environment) {
		return entity.isSendEMail();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MOrder_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
