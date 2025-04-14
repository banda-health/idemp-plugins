package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_MigrationScript;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_MigrationScriptResolver extends POResolver<X_AD_MigrationScript> implements GraphQLResolver<X_AD_MigrationScript> {


	public Boolean isApply(X_AD_MigrationScript entity, DataFetchingEnvironment environment) {
		return entity.isApply();
	}

	public static Map<String, String> STATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("IP", "b1061f0e-7b42-49b1-bb8e-bdeb9ccfdfbc"); // In Progress
			put("CO", "90d39770-9ad9-4673-9d67-d960a63bd396"); // Completed
			put("ER", "892694c4-8c34-4346-94d0-98455b757c27"); // Error
		}
	};
	public CompletableFuture<MRefList_BH> Status(X_AD_MigrationScript entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(STATUS_UUIDS_BY_VALUE.get(entity.getStatus()));
	}

}
