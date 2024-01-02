package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.M_Element;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReferenceResolver extends POResolver<MReference_BH> implements GraphQLResolver<MReference_BH> {



	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	public CompletableFuture<M_Element> AD_Element(MReference_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Element_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, M_Element> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ElementDataLoader.AD_Element_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Element_ID());
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MReference_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	public Boolean IsOrderByValue(MReference_BH entity, DataFetchingEnvironment environment) {
		return entity.isOrderByValue();
	}

	static Map<String, String> VALIDATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "6fd23c6a-c10e-4b49-9c48-becb3f819527");
			put("D", "b5ced8c7-63e7-453b-a0f7-678aa6eff4aa");
			put("T", "3acb50b1-a8c9-4754-a52e-5e3d427a4fa8");
		}
	};
	public CompletableFuture<MRefList_BH> ValidationType(MReference_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getValidationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(VALIDATIONTYPE_UUIDS_BY_VALUE.get(entity.getValidationType()));
	}

}
