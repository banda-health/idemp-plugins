package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MStorageProvider;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StorageProviderResolver extends POResolver<MStorageProvider> implements GraphQLResolver<MStorageProvider> {


	static Map<String, String> METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("FileSystem", "826c7b7b-8412-4b36-a912-dcf4ae56c9c0");
			put("DB", "f84a4deb-5b8b-4951-86af-3b0ae957ca9b");
		}
	};
	public CompletableFuture<MRefList_BH> Method(MStorageProvider entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(METHOD_UUIDS_BY_VALUE.get(entity.getMethod()));
	}

}
