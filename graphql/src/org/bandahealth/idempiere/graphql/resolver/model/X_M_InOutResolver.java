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
import org.compiere.model.MRefList;
import org.compiere.model.MShipper;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutResolver extends POResolver<MInOut_BH> implements GraphQLResolver<MInOut_BH> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public CompletableFuture<MBHVisit> BH_Visit(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_VisitDataLoader.BH_Visit_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getBH_Visit_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.C_Activity_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.C_Campaign_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.C_Charge_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.C_DocType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.C_Invoice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.C_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}

	static Map<String, String> DELIVERYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.DELIVERYRULE_AfterPayment, "20fd42a7-54c5-4a60-8e1a-4cda5c9856ee");
			put(MInOut_BH.DELIVERYRULE_Availability, "89125067-1315-434e-a112-2593bb681a9d");
			put(MInOut_BH.DELIVERYRULE_CompleteLine, "613c2dee-60a6-46ea-8a0a-646cd4a10c61");
			put(MInOut_BH.DELIVERYRULE_CompleteOrder, "3f011d8d-6d3d-4d12-aa4c-c5adea40b464");
			put(MInOut_BH.DELIVERYRULE_Force, "3db26d28-62ee-454c-b25b-5abbef460042");
			put(MInOut_BH.DELIVERYRULE_Manual, "d9b69f78-edb1-4179-a56e-33cbca133673");
		}
	};
	public CompletableFuture<MRefList> DeliveryRule_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DELIVERYRULE_UUIDS_BY_VALUE.get(entity.getDeliveryRule()));
	}

	static Map<String, String> DELIVERYVIARULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.DELIVERYVIARULE_Pickup, "701ff061-98de-431b-b6ab-b14da4987285");
			put(MInOut_BH.DELIVERYVIARULE_Delivery, "9d1b379c-84b1-43b1-b735-8c7467cb1b1a");
			put(MInOut_BH.DELIVERYVIARULE_Shipper, "19951c20-3a06-4eb5-a0c2-fc8b27e408a7");
		}
	};
	public CompletableFuture<MRefList> DeliveryViaRule_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryViaRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DELIVERYVIARULE_UUIDS_BY_VALUE.get(entity.getDeliveryViaRule()));
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.DOCACTION_Complete, "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put(MInOut_BH.DOCACTION_Approve, "f80665a4-0db1-4609-be56-5d69b762d169");
			put(MInOut_BH.DOCACTION_Reject, "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put(MInOut_BH.DOCACTION_Post, "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put(MInOut_BH.DOCACTION_Void, "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put(MInOut_BH.DOCACTION_Close, "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put(MInOut_BH.DOCACTION_Reverse_Correct, "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put(MInOut_BH.DOCACTION_Reverse_Accrual, "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put(MInOut_BH.DOCACTION_Invalidate, "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put(MInOut_BH.DOCACTION_Re_Activate, "c8f55635-67a3-42ae-b626-2064acb2e260");
			put(MInOut_BH.DOCACTION_None, "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put(MInOut_BH.DOCACTION_Prepare, "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put(MInOut_BH.DOCACTION_Unlock, "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put(MInOut_BH.DOCACTION_WaitComplete, "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList> DocAction_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.DOCSTATUS_Drafted, "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put(MInOut_BH.DOCSTATUS_Completed, "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put(MInOut_BH.DOCSTATUS_Approved, "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put(MInOut_BH.DOCSTATUS_NotApproved, "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put(MInOut_BH.DOCSTATUS_Voided, "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put(MInOut_BH.DOCSTATUS_Invalid, "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put(MInOut_BH.DOCSTATUS_Reversed, "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put(MInOut_BH.DOCSTATUS_Closed, "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put(MInOut_BH.DOCSTATUS_Unknown, "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put(MInOut_BH.DOCSTATUS_InProgress, "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put(MInOut_BH.DOCSTATUS_WaitingPayment, "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put(MInOut_BH.DOCSTATUS_WaitingConfirmation, "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList> DocStatus_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}


	/**
	 * Get Drop Ship Business Partner.
	 *
	 * @return Business Partner to ship to
	 */
	public CompletableFuture<MBPartner_BH> DropShip_BPartner(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDropShip_BPartner_ID());
	}


	/**
	 * Get Drop Shipment Location.
	 *
	 * @return Business Partner Location for shipping to
	 */
	public CompletableFuture<MBPartnerLocation> DropShip_Location(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDropShip_Location_ID());
	}


	/**
	 * Get Drop Shipment Contact.
	 *
	 * @return Business Partner Contact for drop shipment
	 */
	public CompletableFuture<MUser_BH> DropShip_User(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDropShip_User_ID());
	}

	static Map<String, String> FOB_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.FOB_FOBOrigin, "ab88c68f-4805-45b6-ba40-6660f9725674");
			put(MInOut_BH.FOB_ExWorks, "79961545-0bbb-4f57-bb8b-f86cd3286a76");
			put(MInOut_BH.FOB_CFR_CostAndFreight, "77fbf8dc-b281-4d56-ba20-7d2493fcbbdb");
			put(MInOut_BH.FOB_CIF_CostInsuranceAndFreightFedEx, "328afab3-1f0b-4c42-8156-d0d9175d48ba");
			put(MInOut_BH.FOB_CIP_CarriageAndInsurancePaidToFedEx, "f97dd6d1-fe36-43bf-98a0-97da3dd15ccb");
			put(MInOut_BH.FOB_CPT_CarriagePaidTo, "e30a9395-3a3e-4276-9dd0-2329892d633d");
			put(MInOut_BH.FOB_DAF_DeliveredAtFrontier, "58bb2d2a-3d5c-47ef-88e9-fc851832734c");
			put(MInOut_BH.FOB_DDP_DeliveredDutyPaidFedEx, "4828ecf4-b58d-4769-b77d-d2fae6e8ad59");
			put(MInOut_BH.FOB_DDU_DeliveredDutyUnpaidFedEx, "e483c7a9-58d1-47d9-9c8c-8daf142cf664");
			put(MInOut_BH.FOB_DEQ_DeliveredExQuay, "f1891d28-a462-417d-a977-aa427c5f95be");
			put(MInOut_BH.FOB_DES_DeliveredExShip, "7a884a23-7f14-4962-95fa-3ef56804cb3c");
			put(MInOut_BH.FOB_DomesticFOBDestination, "8063a230-c9ca-43f4-84fa-9199f3e18a3a");
			put(MInOut_BH.FOB_EXW_ExWorksFedEx, "478fb606-7928-4b79-8caf-92278775f835");
			put(MInOut_BH.FOB_FAS_FreeAlongsideShip, "b247c940-4974-44c4-92db-567f6a170635");
			put(MInOut_BH.FOB_FCA_FreeCarrierFedEx, "66c90182-879e-44a5-844d-a959c0c4a882");
			put(MInOut_BH.FOB_FOB_FreeOnBoardFedEx, "30141c28-d81e-45cf-b403-7b68e4ace907");
		}
	};
	public CompletableFuture<MRefList> FOB_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFOB())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(FOB_UUIDS_BY_VALUE.get(entity.getFOB()));
	}

	static Map<String, String> FREIGHTCHARGES_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.FREIGHTCHARGES_Collect, "8f1b9716-37d3-4c2b-b6c8-0d9e369d5949");
			put(MInOut_BH.FREIGHTCHARGES_3rdParty, "ecf5bea8-58cd-41d8-947d-7fe2da259c1f");
			put(MInOut_BH.FREIGHTCHARGES_Consignee, "5705e6a3-9457-4af0-b444-6cb0f86e95aa");
			put(MInOut_BH.FREIGHTCHARGES_Prepaid, "509eb116-2d24-4144-9d94-4e6f5980687d");
			put(MInOut_BH.FREIGHTCHARGES_PrepaidAndBill, "0e39eb81-f71c-4c44-a9b1-a1af86304c32");
		}
	};
	public CompletableFuture<MRefList> FreightCharges_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCharges())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(FREIGHTCHARGES_UUIDS_BY_VALUE.get(entity.getFreightCharges()));
	}

	static Map<String, String> FREIGHTCOSTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.FREIGHTCOSTRULE_FreightIncluded, "82df2976-c23f-43fb-91e9-b2b4ab27063f");
			put(MInOut_BH.FREIGHTCOSTRULE_FixPrice, "3c97df02-d8ed-4bca-91b2-c4ca115533c4");
			put(MInOut_BH.FREIGHTCOSTRULE_Calculated, "43e070a0-f583-4b5d-a11c-6e5945a99272");
			put(MInOut_BH.FREIGHTCOSTRULE_Line, "623c0263-3294-4073-9884-e5cb78edb1bd");
		}
	};
	public CompletableFuture<MRefList> FreightCostRule_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCostRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(FREIGHTCOSTRULE_UUIDS_BY_VALUE.get(entity.getFreightCostRule()));
	}

	static Map<String, String> INSURANCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.INSURANCE_Insure, "38fe063a-ebc1-43e4-8e13-ffe3e44cf678");
			put(MInOut_BH.INSURANCE_DoNotInsure, "19ba90f2-d281-4217-9460-be081c4cb49d");
		}
	};
	public CompletableFuture<MRefList> Insurance_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInsurance())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(INSURANCE_UUIDS_BY_VALUE.get(entity.getInsurance()));
	}


	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public CompletableFuture<MRMA> M_RMA(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMA_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRMA> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMADataLoader.M_RMA_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_RMA_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.M_Shipper_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	static Map<String, String> MOVEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.MOVEMENTTYPE_CustomerShipment, "00fd790c-e7d8-4399-8407-ce735e91a3a8");
			put(MInOut_BH.MOVEMENTTYPE_CustomerReturns, "65a33af1-d135-4c2d-980c-2c299cb0bb1c");
			put(MInOut_BH.MOVEMENTTYPE_VendorReceipts, "edfd62f3-f88e-4efe-a2cd-6e24452bf30e");
			put(MInOut_BH.MOVEMENTTYPE_VendorReturns, "1be42e0f-3096-4796-9c70-d6e40de09a06");
			put(MInOut_BH.MOVEMENTTYPE_InventoryOut, "76be392a-c953-4d09-9ee7-d688dd3fda7d");
			put(MInOut_BH.MOVEMENTTYPE_InventoryIn, "ec8fde60-8853-46dc-ab07-2208e7c309c0");
			put(MInOut_BH.MOVEMENTTYPE_MovementFrom, "eafaee32-9f7a-439b-89d6-3470367fc02b");
			put(MInOut_BH.MOVEMENTTYPE_MovementTo, "fb18d31f-977e-4b86-9516-84bbb420d830");
			put(MInOut_BH.MOVEMENTTYPE_ProductionPlus, "1d7891c4-ff13-46f4-8c9c-c07ae46c214c");
			put(MInOut_BH.MOVEMENTTYPE_Production_, "0ae07aaa-5d4a-4cea-9151-cbdf38f3c8e6");
			put(MInOut_BH.MOVEMENTTYPE_WorkOrderPlus, "251b4cb0-7d98-4183-9114-6784d48359da");
			put(MInOut_BH.MOVEMENTTYPE_WorkOrder_, "aca9152b-34cb-44fa-8a5b-d519dd804637");
		}
	};
	public CompletableFuture<MRefList> MovementType_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMovementType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(MOVEMENTTYPE_UUIDS_BY_VALUE.get(entity.getMovementType()));
	}

	static Map<String, String> POSTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.POSTED_NotPosted, "f8a3fa32-e816-46b0-8ffa-8f75a9a6f8ce");
			put(MInOut_BH.POSTED_Posted, "238cfb09-41c2-43ef-81d3-785f45e69eff");
			put(MInOut_BH.POSTED_NotBalanced, "b356ec40-2b7c-45bd-ae61-5f62875b41ac");
			put(MInOut_BH.POSTED_NotConvertibleNoRate, "1e0390a8-f7be-4e8b-bd9a-e7c56913f39d");
			put(MInOut_BH.POSTED_PeriodClosed, "4afac137-c9db-4bbc-ac61-b0c642f7807e");
			put(MInOut_BH.POSTED_PostPrepared, "b2188064-c2e1-4319-8d1d-59145d49842b");
			put(MInOut_BH.POSTED_InvalidAccount, "3bd142e3-e397-42b9-ac64-b2c98d970426");
			put(MInOut_BH.POSTED_PostingError, "bd259a9b-d9a3-4396-ae5c-124968ae3f4d");
			put(MInOut_BH.POSTED_Deferred, "0630b5d2-0fe4-4ef8-9d2f-a14791c02c7d");
		}
	};
	public CompletableFuture<MRefList> Posted_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPosted())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTED_UUIDS_BY_VALUE.get(entity.getPosted()));
	}

	static Map<String, String> PRIORITYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInOut_BH.PRIORITYRULE_High, "eb2a15e0-e10d-47df-9ddd-d12d39b32007");
			put(MInOut_BH.PRIORITYRULE_Medium, "6ca5bed6-2fd6-4afd-b3a8-d9c91452e829");
			put(MInOut_BH.PRIORITYRULE_Low, "74703c05-07aa-47d6-8ee3-e884ce2f505e");
			put(MInOut_BH.PRIORITYRULE_Urgent, "6d26a706-aa9f-4111-8b5b-741aa48476d9");
			put(MInOut_BH.PRIORITYRULE_Minor, "c349e252-ad91-483f-b53f-0e92fabbaca5");
		}
	};
	public CompletableFuture<MRefList> PriorityRule_RL(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriorityRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PRIORITYRULE_UUIDS_BY_VALUE.get(entity.getPriorityRule()));
	}


	/**
	 * Get Return Partner.
	 *
	 * @return Return Partner
	 */
	public CompletableFuture<MBPartner_BH> ReturnBPartner(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReturnBPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getReturnBPartner_ID());
	}


	/**
	 * Get Return Location.
	 *
	 * @return Return Location
	 */
	public CompletableFuture<MBPartnerLocation> ReturnLocation(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReturnLocation_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getReturnLocation_ID());
	}


	/**
	 * Get Return User/Contact.
	 *
	 * @return Return User/Contact
	 */
	public CompletableFuture<MUser_BH> ReturnUser(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReturnUser_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getReturnUser_ID());
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<MInOut_BH> Reversal(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOut_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.M_InOut_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getReversal_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSalesRep_ID());
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MInOut_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser2_ID());
	}

}
