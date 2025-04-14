package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_Package_Imp_Proc;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_Imp_ProcResolver extends POResolver<X_AD_Package_Imp_Proc> implements GraphQLResolver<X_AD_Package_Imp_Proc> {


	public Boolean AD_Override_Dict(X_AD_Package_Imp_Proc entity, DataFetchingEnvironment environment) {
		return entity.isAD_Override_Dict();
	}

	public static Map<String, String> AD_PACKAGE_SOURCE_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("File", "824614cb-169f-49ae-988f-54bb43f98647"); // File
			put("WS", "b07945d7-3b60-49b3-9565-63d8b54f7ed3"); // WebService
		}
	};
	public CompletableFuture<MRefList_BH> AD_Package_Source_Type(X_AD_Package_Imp_Proc entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_Package_Source_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(AD_PACKAGE_SOURCE_TYPE_UUIDS_BY_VALUE.get(entity.getAD_Package_Source_Type()));
	}

	public Boolean Processing(X_AD_Package_Imp_Proc entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
