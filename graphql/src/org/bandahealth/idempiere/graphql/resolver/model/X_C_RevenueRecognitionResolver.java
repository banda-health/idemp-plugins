package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRevenueRecognition;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RevenueRecognitionResolver extends POResolver<MRevenueRecognition> implements GraphQLResolver<MRevenueRecognition> {


	public Boolean IsTimeBased(MRevenueRecognition entity, DataFetchingEnvironment environment) {
		return entity.isTimeBased();
	}

	public static Map<String, String> RECOGNITIONFREQUENCY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "2e36cfa4-dfe7-4f3f-accd-6c8d1ef06a7d"); // Month
			put("Q", "bfd94785-d2a8-4b42-98d4-0c9e04d49b46"); // Quarter
			put("Y", "3fb681ad-7138-46e2-8d68-a6992bf1deb7"); // Year
		}
	};
	public CompletableFuture<MRefList_BH> RecognitionFrequency(MRevenueRecognition entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRecognitionFrequency())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(RECOGNITIONFREQUENCY_UUIDS_BY_VALUE.get(entity.getRecognitionFrequency()));
	}

}
