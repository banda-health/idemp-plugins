package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_ImpFormat;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImpFormatResolver extends POResolver<X_AD_ImpFormat> implements GraphQLResolver<X_AD_ImpFormat> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_ImpFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public static Map<String, String> FORMATTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("F", "142c8cd7-51cb-4f48-ae47-b97a59a67d74"); // Fixed Position
			put("C", "e02316a4-a5e8-4fa0-a6d6-75c8b21c9da0"); // Comma Separated
			put("T", "1a321c70-01a6-4e18-a684-4e43e011811f"); // Tab Separated
			put("X", "acdf2952-a33f-4ddf-853c-cee7e4e6d3d7"); // XML
			put("U", "22622479-b1a2-4176-b5f1-9dc19585d0d9"); // Custom Separator Char
		}
	};
	public CompletableFuture<MRefList_BH> FormatType(X_AD_ImpFormat entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFormatType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FORMATTYPE_UUIDS_BY_VALUE.get(entity.getFormatType()));
	}

	public Boolean Processing(X_AD_ImpFormat entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
