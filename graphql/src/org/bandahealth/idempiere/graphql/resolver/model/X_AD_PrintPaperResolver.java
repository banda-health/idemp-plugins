package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_PrintPaper;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintPaperResolver extends POResolver<X_AD_PrintPaper> implements GraphQLResolver<X_AD_PrintPaper> {


	static Map<String, String> DIMENSIONUNITS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "4ef40a19-ee82-4261-992a-0c564cb8fb6c");
			put("I", "66271167-86b4-41fb-9343-ad5224a30f70");
		}
	};
	public CompletableFuture<MRefList_BH> DimensionUnits(X_AD_PrintPaper entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDimensionUnits())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DIMENSIONUNITS_UUIDS_BY_VALUE.get(entity.getDimensionUnits()));
	}

	public Boolean IsDefault(X_AD_PrintPaper entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsLandscape(X_AD_PrintPaper entity, DataFetchingEnvironment environment) {
		return entity.isLandscape();
	}

	public Boolean Processing(X_AD_PrintPaper entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
