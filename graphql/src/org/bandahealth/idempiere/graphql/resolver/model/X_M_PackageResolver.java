package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_ShippingAcctDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperLabelsDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPackagingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPickupTypesDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingProcessorDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MPackage;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.MUOM;
import org.compiere.model.X_C_BP_ShippingAcct;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageResolver extends POResolver<MPackage> implements GraphQLResolver<MPackage> {



	/**
	 * Get Business Partner Shipping Account.
	 *
	 * @return Business Partner Shipping Account
	 */
	public CompletableFuture<X_C_BP_ShippingAcct> C_BP_ShippingAcct(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_ShippingAcct_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_BP_ShippingAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_ShippingAcctDataLoader.DATALOADER_C_BP_ShippingAcct_BY_ID);
		return dataLoader.load(entity.getC_BP_ShippingAcct_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
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
	public CompletableFuture<MCurrency_BH> C_Currency(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public CompletableFuture<MUOM> C_UOM_Length(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Length_ID() <= 0) {
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
	public CompletableFuture<MUOM> C_UOM_Weight(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Weight_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Weight_ID());
	}

	public Boolean CashOnDelivery(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isCashOnDelivery();
	}

	public Boolean DeliveryConfirmation(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isDeliveryConfirmation();
	}

	static Map<String, String> DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ADULT", "a1a27ca4-c532-43ed-b0e5-62354ac6e929");
			put("DIRECT", "1dae42a8-7890-455a-b8eb-dda7099364cd");
			put("INDIRECT", "c1bc3cc6-ecae-46b8-8536-788aaaf7357e");
			put("SERVICE_DEFAULT", "fb3f11bc-3d34-4e1d-8cb9-eb84a39771e3");
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryConfirmationType(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryConfirmationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE.get(entity.getDeliveryConfirmationType()));
	}

	static Map<String, String> DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "04881489-2fb4-4f4e-b67e-245510d8ab06");
			put("2", "58c7f256-84d9-416b-8031-b6a48830eb21");
			put("2.1", "5574e931-91d8-4684-974c-93956c78e17d");
			put("2.2", "e52ea532-1ea9-49eb-9ab2-70e80007076c");
			put("3", "78a27540-58a8-4cf7-b662-0837f06d6382");
			put("4", "31439946-f315-44fd-91d7-0b15e9bf9844");
			put("4.1", "5eddf289-3be4-4326-bfe8-846fa4b55463");
			put("4.2", "eba0280d-3caf-462e-9a74-5ffc9faa263e");
			put("4.3", "86119219-f3f5-4738-bb70-e1977f59877b");
			put("5", "2379190e-85d5-4e9b-abc6-374a76d977e7");
			put("5.1", "23892cbd-b3c1-4629-b639-ed84cda9367a");
			put("5.2", "2c0d0d79-0692-4ddb-b1ae-4c39ac0f2189");
			put("6", "825615c9-b2d4-4c8a-8e8f-b68b130aad74");
			put("6.1", "e6379aa4-79ac-467c-8220-121e902d8b42");
			put("6.2", "a5a9d59a-c050-49f1-8632-0f537edab36f");
			put("7", "7ae8b1dc-4a6d-4e27-a36a-d655181bd7e8");
			put("8", "5a8461bb-3888-4d06-8ea0-3bb161d61415");
			put("9", "1f69e16e-f4a1-4d3d-beb2-772951cfa99a");
		}
	};
	public CompletableFuture<MRefList_BH> DotHazardClassOrDivision(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDotHazardClassOrDivision())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE.get(entity.getDotHazardClassOrDivision()));
	}

	static Map<String, String> FOB_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A_DFOBO", "ab88c68f-4805-45b6-ba40-6660f9725674");
			put("B_EXW", "79961545-0bbb-4f57-bb8b-f86cd3286a76");
			put("CFR", "77fbf8dc-b281-4d56-ba20-7d2493fcbbdb");
			put("CIF", "328afab3-1f0b-4c42-8156-d0d9175d48ba");
			put("CIP", "f97dd6d1-fe36-43bf-98a0-97da3dd15ccb");
			put("CPT", "e30a9395-3a3e-4276-9dd0-2329892d633d");
			put("DAF", "58bb2d2a-3d5c-47ef-88e9-fc851832734c");
			put("DDP", "4828ecf4-b58d-4769-b77d-d2fae6e8ad59");
			put("DDU", "e483c7a9-58d1-47d9-9c8c-8daf142cf664");
			put("DEQ", "f1891d28-a462-417d-a977-aa427c5f95be");
			put("DES", "7a884a23-7f14-4962-95fa-3ef56804cb3c");
			put("DFOBD", "8063a230-c9ca-43f4-84fa-9199f3e18a3a");
			put("EXW", "478fb606-7928-4b79-8caf-92278775f835");
			put("FAS", "b247c940-4974-44c4-92db-567f6a170635");
			put("FCA", "66c90182-879e-44a5-844d-a959c0c4a882");
			put("FOB", "30141c28-d81e-45cf-b403-7b68e4ace907");
		}
	};
	public CompletableFuture<MRefList_BH> FOB(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFOB())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FOB_UUIDS_BY_VALUE.get(entity.getFOB()));
	}

	static Map<String, String> FREIGHTCHARGES_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A_Col", "8f1b9716-37d3-4c2b-b6c8-0d9e369d5949");
			put("B_3P", "ecf5bea8-58cd-41d8-947d-7fe2da259c1f");
			put("C_Con", "5705e6a3-9457-4af0-b444-6cb0f86e95aa");
			put("D_PP", "509eb116-2d24-4144-9d94-4e6f5980687d");
			put("E_PPB", "0e39eb81-f71c-4c44-a9b1-a1af86304c32");
		}
	};
	public CompletableFuture<MRefList_BH> FreightCharges(MPackage entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartnerLocation> HoldAddress(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getHoldAddress_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getHoldAddress_ID());
	}

	static Map<String, String> HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("APPOINTMENT", "fba057eb-ce4d-4af4-b956-a1cf2c759a16");
			put("DATE_CERTAIN", "28903fcd-9f63-4fe4-9f07-2325c5eb74e9");
			put("EVENING", "c9af6b66-e0d9-4bf2-bb94-d0e91c15b572");
		}
	};
	public CompletableFuture<MRefList_BH> HomeDeliveryPremiumType(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getHomeDeliveryPremiumType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE.get(entity.getHomeDeliveryPremiumType()));
	}

	static Map<String, String> INSURANCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "38fe063a-ebc1-43e4-8e13-ffe3e44cf678");
			put("2", "19ba90f2-d281-4217-9460-be081c4cb49d");
		}
	};
	public CompletableFuture<MRefList_BH> Insurance(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInsurance())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(INSURANCE_UUIDS_BY_VALUE.get(entity.getInsurance()));
	}

	public Boolean IsAccessible(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isAccessible();
	}

	public Boolean IsAddedHandling(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isAddedHandling();
	}

	public Boolean IsCargoAircraftOnly(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isCargoAircraftOnly();
	}

	public Boolean IsDryIce(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isDryIce();
	}

	public Boolean IsDutiable(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isDutiable();
	}

	public Boolean IsFutureDayShipment(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isFutureDayShipment();
	}

	public Boolean IsHazMat(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isHazMat();
	}

	public Boolean IsHoldAtLocation(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isHoldAtLocation();
	}

	public Boolean IsIgnoreZipNotFound(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isIgnoreZipNotFound();
	}

	public Boolean IsIgnoreZipStateNotMatch(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isIgnoreZipStateNotMatch();
	}

	public Boolean IsResidential(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isResidential();
	}

	public Boolean IsSaturdayDelivery(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isSaturdayDelivery();
	}

	public Boolean IsSaturdayPickup(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isSaturdayPickup();
	}

	public Boolean IsVerbalConfirmation(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isVerbalConfirmation();
	}


	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public CompletableFuture<MInOut_BH> M_InOut(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOut_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOut_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.DATALOADER_M_InOut_BY_ID);
		return dataLoader.load(entity.getM_InOut_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() <= 0) {
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
	public CompletableFuture<MShipperLabels> M_ShipperLabels(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperLabels_ID() <= 0) {
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
	public CompletableFuture<MShipperPackaging> M_ShipperPackaging(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperPackaging_ID() <= 0) {
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
	public CompletableFuture<MShipperPickupTypes> M_ShipperPickupTypes(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShipperPickupTypes_ID() <= 0) {
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
	public CompletableFuture<MShippingProcessor> M_ShippingProcessor(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getM_ShippingProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MShippingProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShippingProcessorDataLoader.DATALOADER_M_ShippingProcessor_BY_ID);
		return dataLoader.load(entity.getM_ShippingProcessor_ID());
	}

	static Map<String, String> NOTIFICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("RE", "87002ef2-dd55-4bed-8142-f3637e392a88");
			put("RS", "98057d6b-739c-44a1-8be6-9476830cd3bb");
			put("SE", "b7b3d7c7-de4a-40ae-94f6-076b6258fa62");
		}
	};
	public CompletableFuture<MRefList_BH> NotificationType(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNotificationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(NOTIFICATIONTYPE_UUIDS_BY_VALUE.get(entity.getNotificationType()));
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
	public CompletableFuture<MRefList_BH> PaymentRule(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	public Boolean Processed(MPackage entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
