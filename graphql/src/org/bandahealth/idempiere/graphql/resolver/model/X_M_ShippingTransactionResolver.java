package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_ShippingAcctDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PackageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperLabelsDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPackagingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPickupTypesDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingProcessorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MPackage;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.MShippingTransaction;
import org.compiere.model.MUOM;
import org.compiere.model.X_C_BP_ShippingAcct;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingTransactionResolver extends POResolver<MShippingTransaction> implements GraphQLResolver<MShippingTransaction> {


	public static Map<String, String> ACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("RI", "0279b1c5-cf5d-46fb-9e5c-a1413228f90c"); // Rate Inquiry
			put("VS", "4fc424cc-8d7d-421a-9d17-2ed852501501"); // Void Shipment
			put("PS", "c528f5cd-d8a0-4b7d-8bdb-ac456350cb7b"); // Process Shipment
		}
	};
	public CompletableFuture<MRefList_BH> Action(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACTION_UUIDS_BY_VALUE.get(entity.getAction()));
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Invoice Location.
	 *
	 * @return Business Partner Location for invoicing
	 */
	public CompletableFuture<MBPartnerLocation> Bill_Location(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getBill_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getBill_Location_ID());
	}


	/**
	 * Get Business Partner Shipping Account.
	 *
	 * @return Business Partner Shipping Account
	 */
	public CompletableFuture<X_C_BP_ShippingAcct> C_BP_ShippingAcct(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_ShippingAcct_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_C_BP_ShippingAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_ShippingAcctDataLoader.DATALOADER_C_BP_ShippingAcct_BY_ID);
		return dataLoader.load(entity.getC_BP_ShippingAcct_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MShippingTransaction entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 0) {
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
	public CompletableFuture<MOrder_BH> C_Order(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public CompletableFuture<MUOM> C_UOM_Length(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Length_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Length_ID());
	}


	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	public CompletableFuture<MUOM> C_UOM_Weight(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Weight_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Weight_ID());
	}

	public Boolean CashOnDelivery(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isCashOnDelivery();
	}

	public Boolean DeliveryConfirmation(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isDeliveryConfirmation();
	}

	public static Map<String, String> DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ADULT", "a1a27ca4-c532-43ed-b0e5-62354ac6e929"); // Adult
			put("DIRECT", "1dae42a8-7890-455a-b8eb-dda7099364cd"); // Direct
			put("INDIRECT", "c1bc3cc6-ecae-46b8-8536-788aaaf7357e"); // Indirect
			put("SERVICE_DEFAULT", "fb3f11bc-3d34-4e1d-8cb9-eb84a39771e3"); // Service Default
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryConfirmationType(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryConfirmationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE.get(entity.getDeliveryConfirmationType()));
	}

	public static Map<String, String> DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "04881489-2fb4-4f4e-b67e-245510d8ab06"); // Class 1 - Explosives
			put("2", "58c7f256-84d9-416b-8031-b6a48830eb21"); // Class 2 - Gases
			put("2.1", "5574e931-91d8-4684-974c-93956c78e17d"); // 2.1 - Flammable Gas
			put("2.2", "e52ea532-1ea9-49eb-9ab2-70e80007076c"); // 2.2 - Nonflammable Gas
			put("3", "78a27540-58a8-4cf7-b662-0837f06d6382"); // Class 3 - Flammable Liquids
			put("4", "31439946-f315-44fd-91d7-0b15e9bf9844"); // Class 4
			put("4.1", "5eddf289-3be4-4326-bfe8-846fa4b55463"); // 4.1 - Flammable Solids
			put("4.2", "eba0280d-3caf-462e-9a74-5ffc9faa263e"); // 4.2 - Spontaneous Combustibles
			put("4.3", "86119219-f3f5-4738-bb70-e1977f59877b"); // 4.3 - Dangerous When Wet
			put("5", "2379190e-85d5-4e9b-abc6-374a76d977e7"); // Class 5 - Oxidizing Substances and Organic Peroxides
			put("5.1", "23892cbd-b3c1-4629-b639-ed84cda9367a"); // 5.1 - Oxidizers
			put("5.2", "2c0d0d79-0692-4ddb-b1ae-4c39ac0f2189"); // 5.2 - Organic Peroxides
			put("6", "825615c9-b2d4-4c8a-8e8f-b68b130aad74"); // Class 6 - Toxic (Poisonous) and Infectious Substances
			put("6.1", "e6379aa4-79ac-467c-8220-121e902d8b42"); // 6.1 - Toxic Substances
			put("6.2", "a5a9d59a-c050-49f1-8632-0f537edab36f"); // 6.2 - Infectious Substances
			put("7", "7ae8b1dc-4a6d-4e27-a36a-d655181bd7e8"); // Class 7 - Radioactive Material
			put("8", "5a8461bb-3888-4d06-8ea0-3bb161d61415"); // Class 8 - Corrosives
			put("9", "1f69e16e-f4a1-4d3d-beb2-772951cfa99a"); // Class 9 - Miscellaneous Dangerous Goods
		}
	};
	public CompletableFuture<MRefList_BH> DotHazardClassOrDivision(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDotHazardClassOrDivision())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE.get(entity.getDotHazardClassOrDivision()));
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
	public CompletableFuture<MRefList_BH> FOB(MShippingTransaction entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MRefList_BH> FreightCharges(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCharges())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREIGHTCHARGES_UUIDS_BY_VALUE.get(entity.getFreightCharges()));
	}


	/**
	 * Get Hold Address.
	 *
	 * @return Hold Address
	 */
	public CompletableFuture<MBPartnerLocation> HoldAddress(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getHoldAddress_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getHoldAddress_ID());
	}

	public static Map<String, String> HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("APPOINTMENT", "fba057eb-ce4d-4af4-b956-a1cf2c759a16"); // Appointment
			put("DATE_CERTAIN", "28903fcd-9f63-4fe4-9f07-2325c5eb74e9"); // Date Certain
			put("EVENING", "c9af6b66-e0d9-4bf2-bb94-d0e91c15b572"); // Evening
		}
	};
	public CompletableFuture<MRefList_BH> HomeDeliveryPremiumType(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getHomeDeliveryPremiumType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE.get(entity.getHomeDeliveryPremiumType()));
	}

	public static Map<String, String> INSURANCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "38fe063a-ebc1-43e4-8e13-ffe3e44cf678"); // Insure
			put("2", "19ba90f2-d281-4217-9460-be081c4cb49d"); // Do Not Insure
		}
	};
	public CompletableFuture<MRefList_BH> Insurance(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInsurance())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(INSURANCE_UUIDS_BY_VALUE.get(entity.getInsurance()));
	}

	public Boolean IsAccessible(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isAccessible();
	}

	public Boolean IsAddedHandling(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isAddedHandling();
	}

	public Boolean IsAlternateReturnAddress(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isAlternateReturnAddress();
	}

	public Boolean IsCargoAircraftOnly(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isCargoAircraftOnly();
	}

	public Boolean IsDryIce(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isDryIce();
	}

	public Boolean IsDutiable(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isDutiable();
	}

	public Boolean IsFutureDayShipment(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isFutureDayShipment();
	}

	public Boolean IsHazMat(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isHazMat();
	}

	public Boolean IsHoldAtLocation(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isHoldAtLocation();
	}

	public Boolean IsIgnoreZipNotFound(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isIgnoreZipNotFound();
	}

	public Boolean IsIgnoreZipStateNotMatch(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isIgnoreZipStateNotMatch();
	}

	public Boolean IsPriviledgedRate(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isPriviledgedRate();
	}

	public Boolean IsResidential(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isResidential();
	}

	public Boolean IsSaturdayDelivery(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isSaturdayDelivery();
	}

	public Boolean IsSaturdayPickup(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isSaturdayPickup();
	}

	public Boolean IsVerbalConfirmation(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isVerbalConfirmation();
	}


	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public CompletableFuture<MInOut_BH> M_InOut(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOut_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInOut_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.DATALOADER_M_InOut_BY_ID);
		return dataLoader.load(entity.getM_InOut_ID());
	}


	/**
	 * Get Package.
	 *
	 * @return Shipment Package
	 */
	public CompletableFuture<MPackage> M_Package(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Package_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPackage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PackageDataLoader.DATALOADER_M_Package_BY_ID);
		return dataLoader.load(entity.getM_Package_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Shipper Labels.
	 *
	 * @return Shipper Labels
	 */
	public CompletableFuture<MShipperLabels> M_ShipperLabels(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperLabels_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipperLabels> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperLabelsDataLoader.DATALOADER_M_ShipperLabels_BY_ID);
		return dataLoader.load(entity.getM_ShipperLabels_ID());
	}


	/**
	 * Get Shipper Packaging.
	 *
	 * @return Shipper Packaging
	 */
	public CompletableFuture<MShipperPackaging> M_ShipperPackaging(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperPackaging_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipperPackaging> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperPackagingDataLoader.DATALOADER_M_ShipperPackaging_BY_ID);
		return dataLoader.load(entity.getM_ShipperPackaging_ID());
	}


	/**
	 * Get Shipper Pickup Types.
	 *
	 * @return Shipper Pickup Types
	 */
	public CompletableFuture<MShipperPickupTypes> M_ShipperPickupTypes(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperPickupTypes_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShipperPickupTypes> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperPickupTypesDataLoader.DATALOADER_M_ShipperPickupTypes_BY_ID);
		return dataLoader.load(entity.getM_ShipperPickupTypes_ID());
	}


	/**
	 * Get Shipping Processor.
	 *
	 * @return Shipping Processor
	 */
	public CompletableFuture<MShippingProcessor> M_ShippingProcessor(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShippingProcessor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MShippingProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShippingProcessorDataLoader.DATALOADER_M_ShippingProcessor_BY_ID);
		return dataLoader.load(entity.getM_ShippingProcessor_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	public static Map<String, String> NOTIFICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("RE", "87002ef2-dd55-4bed-8142-f3637e392a88"); // Recipient
			put("RS", "98057d6b-739c-44a1-8be6-9476830cd3bb"); // Recipient / Sender
			put("SE", "b7b3d7c7-de4a-40ae-94f6-076b6258fa62"); // Sender
		}
	};
	public CompletableFuture<MRefList_BH> NotificationType(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNotificationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(NOTIFICATIONTYPE_UUIDS_BY_VALUE.get(entity.getNotificationType()));
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
	public CompletableFuture<MRefList_BH> PaymentRule(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	public Boolean Processed(MShippingTransaction entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Return Partner.
	 *
	 * @return Return Partner
	 */
	public CompletableFuture<MBPartner_BH> ReturnBPartner(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getReturnBPartner_ID() < 0) {
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
	public CompletableFuture<MBPartnerLocation> ReturnLocation(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getReturnLocation_ID() < 0) {
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
	public CompletableFuture<MUser_BH> ReturnUser(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getReturnUser_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getReturnUser_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MShippingTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
