package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.model.X_A_Depreciation_Table_Detail;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_Table_DetailResolver extends POResolver<X_A_Depreciation_Table_Detail> implements GraphQLResolver<X_A_Depreciation_Table_Detail> {


	static Map<String, String> A_TABLE_RATE_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_A_Depreciation_Table_Detail.A_TABLE_RATE_TYPE_Amount, "6c03c647-961b-4fb9-ab48-881b071e4077");
			put(X_A_Depreciation_Table_Detail.A_TABLE_RATE_TYPE_Rate, "6181fac0-c69e-49ea-bd8c-2a7e61acccad");
		}
	};
	public CompletableFuture<MRefList> A_Table_Rate_Type_RL(X_A_Depreciation_Table_Detail entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Table_Rate_Type())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_TABLE_RATE_TYPE_UUIDS_BY_VALUE.get(entity.getA_Table_Rate_Type()));
	}

}
