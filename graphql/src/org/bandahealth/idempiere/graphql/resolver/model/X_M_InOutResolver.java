package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMADataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MShipper;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InOutResolver extends POResolver<MInOut_BH> implements GraphQLResolver<MInOut_BH> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
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
	public CompletableFuture<MBHVisit> BH_Visit(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_VisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(entity.getBH_Visit_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 1) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 1) {
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
	public CompletableFuture<MCampaign> C_Campaign(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
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
	public CompletableFuture<MRefList_BH> DeliveryRule(MInOut_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> DeliveryViaRule(MInOut_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> DocAction(MInOut_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> DocStatus(MInOut_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartner_BH> DropShip_BPartner(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_BPartner_ID() < 1) {
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
	public CompletableFuture<MBPartnerLocation> DropShip_Location(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_Location_ID() < 1) {
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
	public CompletableFuture<MUser_BH> DropShip_User(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getDropShip_User_ID());
	}

	public static Map<String, String> FOB_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A_DFOBO", "ab88c68f-4805-45b6-ba40-6660f9725674"); // FOB Origin
			put("B_EXW", "79961545-0bbb-4f57-bb8b-f86cd3286a76"); // Ex Works
			put("CFR", "77fbf8dc-b281-4d56-ba20-7d2493fcbbdb"); // CFR - Cost and Freight
			put("CIF", "328afab3-1f0b-4c42-8156-d0d9175d48ba"); // CIF - Cost, Insurance, and Freight (FedEx)
			put("CIP", "f97dd6d1-fe36-43bf-98a0-97da3dd15ccb"); // CIP - Carriage and Insurance Paid To (FedEx)
			put("CPT", "e30a9395-3a3e-4276-9dd0-2329892d633d"); // CPT - Carriage Paid To
			put("DAF", "58bb2d2a-3d5c-47ef-88e9-fc851832734c"); // DAF - Delivered at Frontier
			put("DDP", "4828ecf4-b58d-4769-b77d-d2fae6e8ad59"); // DDP - Delivered Duty Paid (FedEx)
			put("DDU", "e483c7a9-58d1-47d9-9c8c-8daf142cf664"); // DDU - Delivered Duty Unpaid (FedEx)
			put("DEQ", "f1891d28-a462-417d-a977-aa427c5f95be"); // DEQ - Delivered Ex Quay
			put("DES", "7a884a23-7f14-4962-95fa-3ef56804cb3c"); // DES - Delivered Ex Ship
			put("DFOBD", "8063a230-c9ca-43f4-84fa-9199f3e18a3a"); // Domestic FOB Destination
			put("EXW", "478fb606-7928-4b79-8caf-92278775f835"); // EXW - Ex Works (FedEx)
			put("FAS", "b247c940-4974-44c4-92db-567f6a170635"); // FAS - Free Alongside Ship
			put("FCA", "66c90182-879e-44a5-844d-a959c0c4a882"); // FCA - Free Carrier (FedEx)
			put("FOB", "30141c28-d81e-45cf-b403-7b68e4ace907"); // FOB - Free on Board (FedEx)
		}
	};
	public CompletableFuture<MRefList_BH> FOB(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFOB())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FOB_UUIDS_BY_VALUE.get(entity.getFOB()));
	}

	public static Map<String, String> FREIGHTCHARGES_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A_Col", "8f1b9716-37d3-4c2b-b6c8-0d9e369d5949"); // Collect
			put("B_3P", "ecf5bea8-58cd-41d8-947d-7fe2da259c1f"); // 3rd Party
			put("C_Con", "5705e6a3-9457-4af0-b444-6cb0f86e95aa"); // Consignee
			put("D_PP", "509eb116-2d24-4144-9d94-4e6f5980687d"); // Prepaid
			put("E_PPB", "0e39eb81-f71c-4c44-a9b1-a1af86304c32"); // Prepaid and Bill
		}
	};
	public CompletableFuture<MRefList_BH> FreightCharges(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCharges())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREIGHTCHARGES_UUIDS_BY_VALUE.get(entity.getFreightCharges()));
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
	public CompletableFuture<MRefList_BH> FreightCostRule(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCostRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREIGHTCOSTRULE_UUIDS_BY_VALUE.get(entity.getFreightCostRule()));
	}

	public static Map<String, String> INSURANCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "38fe063a-ebc1-43e4-8e13-ffe3e44cf678"); // Insure
			put("2", "19ba90f2-d281-4217-9460-be081c4cb49d"); // Do Not Insure
		}
	};
	public CompletableFuture<MRefList_BH> Insurance(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInsurance())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(INSURANCE_UUIDS_BY_VALUE.get(entity.getInsurance()));
	}

	public Boolean IsAlternateReturnAddress(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isAlternateReturnAddress();
	}

	public Boolean IsApproved(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsDropShip(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isDropShip();
	}

	public Boolean IsInDispute(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isInDispute();
	}

	public Boolean IsInTransit(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isInTransit();
	}

	public Boolean IsPrinted(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsSOTrx(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}


	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public CompletableFuture<MRMA> M_RMA(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMA_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRMA> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMADataLoader.DATALOADER_M_RMA_BY_ID);
		return dataLoader.load(entity.getM_RMA_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 1) {
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
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	public static Map<String, String> MOVEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C-", "00fd790c-e7d8-4399-8407-ce735e91a3a8"); // Customer Shipment
			put("C+", "65a33af1-d135-4c2d-980c-2c299cb0bb1c"); // Customer Returns
			put("V+", "edfd62f3-f88e-4efe-a2cd-6e24452bf30e"); // Vendor Receipts
			put("V-", "1be42e0f-3096-4796-9c70-d6e40de09a06"); // Vendor Returns
			put("I-", "76be392a-c953-4d09-9ee7-d688dd3fda7d"); // Inventory Out
			put("I+", "ec8fde60-8853-46dc-ab07-2208e7c309c0"); // Inventory In
			put("M-", "eafaee32-9f7a-439b-89d6-3470367fc02b"); // Movement From
			put("M+", "fb18d31f-977e-4b86-9516-84bbb420d830"); // Movement To
			put("P+", "1d7891c4-ff13-46f4-8c9c-c07ae46c214c"); // Production +
			put("P-", "0ae07aaa-5d4a-4cea-9151-cbdf38f3c8e6"); // Production -
			put("W+", "251b4cb0-7d98-4183-9114-6784d48359da"); // Work Order +
			put("W-", "aca9152b-34cb-44fa-8a5b-d519dd804637"); // Work Order -
		}
	};
	public CompletableFuture<MRefList_BH> MovementType(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMovementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MOVEMENTTYPE_UUIDS_BY_VALUE.get(entity.getMovementType()));
	}

	public Boolean Posted(MInOut_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> PriorityRule(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriorityRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PRIORITYRULE_UUIDS_BY_VALUE.get(entity.getPriorityRule()));
	}

	public Boolean Processed(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Return Partner.
	 *
	 * @return Return Partner
	 */
	public CompletableFuture<MBPartner_BH> ReturnBPartner(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReturnBPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getReturnBPartner_ID());
	}


	/**
	 * Get Return Location.
	 *
	 * @return Return Location
	 */
	public CompletableFuture<MBPartnerLocation> ReturnLocation(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReturnLocation_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getReturnLocation_ID());
	}


	/**
	 * Get Return User/Contact.
	 *
	 * @return Return User/Contact
	 */
	public CompletableFuture<MUser_BH> ReturnUser(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReturnUser_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getReturnUser_ID());
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<MInOut_BH> Reversal(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInOut_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.DATALOADER_M_InOut_BY_ID);
		return dataLoader.load(entity.getReversal_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	public Boolean SendEMail(MInOut_BH entity, DataFetchingEnvironment environment) {
		return entity.isSendEMail();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() < 1) {
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
	public CompletableFuture<MElementValue> User2(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
