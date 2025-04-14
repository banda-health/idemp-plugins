package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_Table_HeaderResolver extends POResolver<X_A_Depreciation_Table_Header> implements GraphQLResolver<X_A_Depreciation_Table_Header> {


	public static Map<String, String> A_TABLE_RATE_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AM", "6c03c647-961b-4fb9-ab48-881b071e4077"); // Amount
			put("RT", "6181fac0-c69e-49ea-bd8c-2a7e61acccad"); // Rate
		}
	};
	public CompletableFuture<MRefList_BH> A_Table_Rate_Type(X_A_Depreciation_Table_Header entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Table_Rate_Type())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_TABLE_RATE_TYPE_UUIDS_BY_VALUE.get(entity.getA_Table_Rate_Type()));
	}

	public static Map<String, String> A_TERM_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PR", "35e7efb6-c084-458c-89e6-bdeeb3757add"); // Period
			put("YR", "d34572f8-bbc3-4768-9662-8ae6f48f7398"); // Yearly
		}
	};
	public CompletableFuture<MRefList_BH> A_Term(X_A_Depreciation_Table_Header entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Term())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_TERM_UUIDS_BY_VALUE.get(entity.getA_Term()));
	}

	public Boolean Processed(X_A_Depreciation_Table_Header entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
