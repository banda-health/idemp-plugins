package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_TabDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_ASP_Field;
import org.compiere.model.X_ASP_Tab;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_FieldResolver extends POResolver<X_ASP_Field> implements GraphQLResolver<X_ASP_Field> {



	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	public CompletableFuture<MField_BH> AD_Field(X_ASP_Field entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Field_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MField_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FieldDataLoader.DATALOADER_AD_Field_BY_ID);
		return dataLoader.load(entity.getAD_Field_ID());
	}

	public static Map<String, String> ASP_STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("H", "864906b8-9311-4af2-9464-434e25fa6f72"); // Hide
			put("S", "e06c95b8-62c4-4d5d-b9fc-e23c5049489e"); // Show
			put("U", "e718a86a-8c1d-490d-9d3f-f1a2dfe6af69"); // Undefined
		}
	};
	public CompletableFuture<MRefList_BH> ASP_Status(X_ASP_Field entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getASP_Status())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ASP_STATUS_UUIDS_BY_VALUE.get(entity.getASP_Status()));
	}


	/**
	 * Get ASP Tab.
	 *
	 * @return ASP Tab
	 */
	public CompletableFuture<X_ASP_Tab> ASP_Tab(X_ASP_Field entity, DataFetchingEnvironment environment) {
		if (entity.getASP_Tab_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_ASP_Tab> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_ASP_TabDataLoader.DATALOADER_ASP_Tab_BY_ID);
		return dataLoader.load(entity.getASP_Tab_ID());
	}

}
