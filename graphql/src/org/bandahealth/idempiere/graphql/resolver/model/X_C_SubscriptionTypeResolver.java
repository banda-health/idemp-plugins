package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_C_SubscriptionType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubscriptionTypeResolver extends POResolver<X_C_SubscriptionType> implements GraphQLResolver<X_C_SubscriptionType> {


	static Map<String, String> FREQUENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "80320e2a-1a3c-462f-9af1-09c0af1aab5f");
			put("H", "817d1ba9-4dbe-4105-8ca5-61cf554ac837");
			put("D", "6360c9c7-dbf3-4b2f-bd8b-3465a7fde7a7");
		}
	};
	public CompletableFuture<MRefList_BH> FrequencyType(X_C_SubscriptionType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFrequencyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREQUENCYTYPE_UUIDS_BY_VALUE.get(entity.getFrequencyType()));
	}

}
