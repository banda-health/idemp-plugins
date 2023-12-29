package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.X_PA_Benchmark;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkResolver extends POResolver<X_PA_Benchmark> implements GraphQLResolver<X_PA_Benchmark> {


	static Map<String, String> ACCUMULATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_PA_Benchmark.ACCUMULATIONTYPE_Average, "3d552877-6635-458d-a8b7-7ef7f83be0c3");
			put(X_PA_Benchmark.ACCUMULATIONTYPE_Sum, "bfa804a6-caca-443f-92b3-6cc9672f9f52");
		}
	};
	public CompletableFuture<MRefList> AccumulationType_RL(X_PA_Benchmark entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccumulationType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ACCUMULATIONTYPE_UUIDS_BY_VALUE.get(entity.getAccumulationType()));
	}

}
