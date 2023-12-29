package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_ClassDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_TypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MInOutLine;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_AssetResolver extends POResolver<MAsset> implements GraphQLResolver<MAsset> {


	static Map<String, String> A_ASSET_ACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAsset.A_ASSET_ACTION_Dispose, "fee6717e-7137-4035-9a83-bb96a6d111f8");
			put(MAsset.A_ASSET_ACTION_Inbound, "538261b3-5e19-445d-b54d-350c9b9fac92");
			put(MAsset.A_ASSET_ACTION_Modify, "c72b48b9-f248-4e9d-9fd8-4afae918bef8");
			put(MAsset.A_ASSET_ACTION_Outbound, "c81b8475-74d3-41d5-8ff5-6de9e2db2436");
			put(MAsset.A_ASSET_ACTION_Reevaluate, "084daa2e-0720-47e2-8923-01793426c9a2");
			put(MAsset.A_ASSET_ACTION_Retire, "3a74baee-45d7-4d09-84eb-37efa01e9ca0");
			put(MAsset.A_ASSET_ACTION_Transfer, "194f5d34-a04e-48c2-8e5a-8a81c326657c");
		}
	};
	public CompletableFuture<MRefList> A_Asset_Action_RL(MAsset entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Asset_Action())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_ASSET_ACTION_UUIDS_BY_VALUE.get(entity.getA_Asset_Action()));
	}


	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public CompletableFuture<MAssetClass> A_Asset_Class(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Class_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetClass> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_ClassDataLoader.A_Asset_Class_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Class_ID());
	}


	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public CompletableFuture<MAssetGroup> A_Asset_Group(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_GroupDataLoader.A_Asset_Group_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Group_ID());
	}

	static Map<String, String> A_ASSET_STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAsset.A_ASSET_STATUS_Activated, "d2cdd31e-4373-4f35-8d01-22946c3c6211");
			put(MAsset.A_ASSET_STATUS_Disposed, "dd8c1848-6fb8-4829-8855-7c3b314514fd");
			put(MAsset.A_ASSET_STATUS_Depreciated, "583c5228-ad5d-48cd-819b-97673805b1fa");
			put(MAsset.A_ASSET_STATUS_New, "3f742175-42b0-4775-9eb3-ed5fefd0ca7a");
			put(MAsset.A_ASSET_STATUS_Preservation, "785b94f6-fbd7-49a7-b752-45a6d0df3888");
			put(MAsset.A_ASSET_STATUS_Retired, "9ac1f818-4159-463f-81c4-b55923e94c9e");
			put(MAsset.A_ASSET_STATUS_Sold, "b2aa86a9-566c-4762-98d5-c4b5c243a2cd");
		}
	};
	public CompletableFuture<MRefList> A_Asset_Status_RL(MAsset entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Asset_Status())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_ASSET_STATUS_UUIDS_BY_VALUE.get(entity.getA_Asset_Status()));
	}


	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public CompletableFuture<MAssetType> A_Asset_Type(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Type_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_TypeDataLoader.A_Asset_Type_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Type_ID());
	}


	/**
	 * Get Parent Asset.
	 *
	 * @return Parent Asset
	 */
	public CompletableFuture<MAsset> A_Parent_Asset(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getA_Parent_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Parent_Asset_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MAsset entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MAsset entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	public CompletableFuture<MBPartner_BH> C_BPartnerSR(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerSR_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartnerSR_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.C_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Location_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Lessor.
	 *
	 * @return The Business Partner who rents or leases
	 */
	public CompletableFuture<MBPartner_BH> Lease_BPartner(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getLease_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getLease_BPartner_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.M_InOutLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MAsset entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
