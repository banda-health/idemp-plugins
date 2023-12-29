package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
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
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCurrency;
import org.compiere.model.MPackage;
import org.compiere.model.MRefList;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.MShipperPickupTypes;
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_ShippingAcctDataLoader.C_BP_ShippingAcct_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MPackage entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.C_UOM_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.C_UOM_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_UOM_Weight_ID());
	}

	static Map<String, String> DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MPackage.DELIVERYCONFIRMATIONTYPE_Adult, "a1a27ca4-c532-43ed-b0e5-62354ac6e929");
			put(MPackage.DELIVERYCONFIRMATIONTYPE_Direct, "1dae42a8-7890-455a-b8eb-dda7099364cd");
			put(MPackage.DELIVERYCONFIRMATIONTYPE_Indirect, "c1bc3cc6-ecae-46b8-8536-788aaaf7357e");
			put(MPackage.DELIVERYCONFIRMATIONTYPE_ServiceDefault, "fb3f11bc-3d34-4e1d-8cb9-eb84a39771e3");
		}
	};
	public CompletableFuture<MRefList> DeliveryConfirmationType_RL(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryConfirmationType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DELIVERYCONFIRMATIONTYPE_UUIDS_BY_VALUE.get(entity.getDeliveryConfirmationType()));
	}

	static Map<String, String> DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class1_Explosives, "04881489-2fb4-4f4e-b67e-245510d8ab06");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class2_Gases, "58c7f256-84d9-416b-8031-b6a48830eb21");
			put(MPackage.DOTHAZARDCLASSORDIVISION_21_FlammableGas, "5574e931-91d8-4684-974c-93956c78e17d");
			put(MPackage.DOTHAZARDCLASSORDIVISION_22_NonflammableGas, "e52ea532-1ea9-49eb-9ab2-70e80007076c");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class3_FlammableLiquids, "78a27540-58a8-4cf7-b662-0837f06d6382");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class4, "31439946-f315-44fd-91d7-0b15e9bf9844");
			put(MPackage.DOTHAZARDCLASSORDIVISION_41_FlammableSolids, "5eddf289-3be4-4326-bfe8-846fa4b55463");
			put(MPackage.DOTHAZARDCLASSORDIVISION_42_SpontaneousCombustibles, "eba0280d-3caf-462e-9a74-5ffc9faa263e");
			put(MPackage.DOTHAZARDCLASSORDIVISION_43_DangerousWhenWet, "86119219-f3f5-4738-bb70-e1977f59877b");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class5_OxidizingSubstancesAndOrganicPeroxides, "2379190e-85d5-4e9b-abc6-374a76d977e7");
			put(MPackage.DOTHAZARDCLASSORDIVISION_51_Oxidizers, "23892cbd-b3c1-4629-b639-ed84cda9367a");
			put(MPackage.DOTHAZARDCLASSORDIVISION_52_OrganicPeroxides, "2c0d0d79-0692-4ddb-b1ae-4c39ac0f2189");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class6_ToxicPoisonousAndInfectiousSubstances, "825615c9-b2d4-4c8a-8e8f-b68b130aad74");
			put(MPackage.DOTHAZARDCLASSORDIVISION_61_ToxicSubstances, "e6379aa4-79ac-467c-8220-121e902d8b42");
			put(MPackage.DOTHAZARDCLASSORDIVISION_62_InfectiousSubstances, "a5a9d59a-c050-49f1-8632-0f537edab36f");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class7_RadioactiveMaterial, "7ae8b1dc-4a6d-4e27-a36a-d655181bd7e8");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class8_Corrosives, "5a8461bb-3888-4d06-8ea0-3bb161d61415");
			put(MPackage.DOTHAZARDCLASSORDIVISION_Class9_MiscellaneousDangerousGoods, "1f69e16e-f4a1-4d3d-beb2-772951cfa99a");
		}
	};
	public CompletableFuture<MRefList> DotHazardClassOrDivision_RL(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDotHazardClassOrDivision())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOTHAZARDCLASSORDIVISION_UUIDS_BY_VALUE.get(entity.getDotHazardClassOrDivision()));
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
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHoldAddress_ID());
	}

	static Map<String, String> HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MPackage.HOMEDELIVERYPREMIUMTYPE_Appointment, "fba057eb-ce4d-4af4-b956-a1cf2c759a16");
			put(MPackage.HOMEDELIVERYPREMIUMTYPE_DateCertain, "28903fcd-9f63-4fe4-9f07-2325c5eb74e9");
			put(MPackage.HOMEDELIVERYPREMIUMTYPE_Evening, "c9af6b66-e0d9-4bf2-bb94-d0e91c15b572");
		}
	};
	public CompletableFuture<MRefList> HomeDeliveryPremiumType_RL(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getHomeDeliveryPremiumType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(HOMEDELIVERYPREMIUMTYPE_UUIDS_BY_VALUE.get(entity.getHomeDeliveryPremiumType()));
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.M_InOut_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.M_Shipper_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperLabelsDataLoader.M_ShipperLabels_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperPackagingDataLoader.M_ShipperPackaging_BY_ID_DATA_LOADER);
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
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperPickupTypesDataLoader.M_ShipperPickupTypes_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ShipperPickupTypes_ID());
	}

	static Map<String, String> NOTIFICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MPackage.NOTIFICATIONTYPE_Recipient, "87002ef2-dd55-4bed-8142-f3637e392a88");
			put(MPackage.NOTIFICATIONTYPE_RecipientSender, "98057d6b-739c-44a1-8be6-9476830cd3bb");
			put(MPackage.NOTIFICATIONTYPE_Sender, "b7b3d7c7-de4a-40ae-94f6-076b6258fa62");
		}
	};
	public CompletableFuture<MRefList> NotificationType_RL(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNotificationType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(NOTIFICATIONTYPE_UUIDS_BY_VALUE.get(entity.getNotificationType()));
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MPackage.PAYMENTRULE_Cash, "917130e3-2144-496c-9344-6cf4f7136293");
			put(MPackage.PAYMENTRULE_CreditCard, "68dda00d-c015-498e-b91c-811bab809dab");
			put(MPackage.PAYMENTRULE_DirectDeposit, "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put(MPackage.PAYMENTRULE_Check, "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put(MPackage.PAYMENTRULE_OnCredit, "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put(MPackage.PAYMENTRULE_DirectDebit, "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put(MPackage.PAYMENTRULE_MixedPOSPayment, "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put(MPackage.PAYMENTRULE_MobileAccount, "c524815a-e048-4052-bab5-b7812e27cd64");
			put(MPackage.PAYMENTRULE_CashDrawer, "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList> PaymentRule_RL(MPackage entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

}
