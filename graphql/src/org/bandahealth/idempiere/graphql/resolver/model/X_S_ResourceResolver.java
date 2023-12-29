package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceResolver extends POResolver<MResource> implements GraphQLResolver<MResource> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MResource entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MResource entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	static Map<String, String> MANUFACTURINGRESOURCETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MResource.MANUFACTURINGRESOURCETYPE_ProductionLine, "aa555fe3-54bb-4493-81b1-a7d01b4e5901");
			put(MResource.MANUFACTURINGRESOURCETYPE_Plant, "0aa926a5-b50d-4d53-9bf6-9d23980a818e");
			put(MResource.MANUFACTURINGRESOURCETYPE_WorkCenter, "376e0f68-8652-4356-a738-4a30fda3fcbb");
			put(MResource.MANUFACTURINGRESOURCETYPE_WorkStation, "662bdb0e-3f0f-4dcf-8869-0880f7ced397");
		}
	};
	public CompletableFuture<MRefList> ManufacturingResourceType_RL(MResource entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getManufacturingResourceType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(MANUFACTURINGRESOURCETYPE_UUIDS_BY_VALUE.get(entity.getManufacturingResourceType()));
	}


	/**
	 * Get Resource Type.
	 *
	 * @return Resource Type
	 */
	public CompletableFuture<MResourceType> S_ResourceType(MResource entity, DataFetchingEnvironment environment) {
		if (entity.getS_ResourceType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResourceType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceTypeDataLoader.S_ResourceType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_ResourceType_ID());
	}

}
