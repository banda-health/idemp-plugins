package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_YearDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.compiere.model.MYear;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PeriodResolver extends POResolver<MPeriod> implements GraphQLResolver<MPeriod> {



	/**
	 * Get Year.
	 *
	 * @return Calendar Year
	 */
	public CompletableFuture<MYear> C_Year(MPeriod entity, DataFetchingEnvironment environment) {
		if (entity.getC_Year_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MYear> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_YearDataLoader.C_Year_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Year_ID());
	}

	static Map<String, String> PERIODTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "108b2f61-695d-4949-b813-19c71ad24a07");
			put("A", "99d0bc20-9668-4335-8b52-4d8a9594f76c");
		}
	};
	public CompletableFuture<MRefList> PeriodType_RL(MPeriod entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPeriodType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PERIODTYPE_UUIDS_BY_VALUE.get(entity.getPeriodType()));
	}

}
