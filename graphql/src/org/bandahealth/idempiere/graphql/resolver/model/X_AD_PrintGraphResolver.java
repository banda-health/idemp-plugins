package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatItemDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintFormatItem;
import org.compiere.model.X_AD_PrintGraph;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintGraphResolver extends POResolver<X_AD_PrintGraph> implements GraphQLResolver<X_AD_PrintGraph> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Data Column.
	 *
	 * @return Data Column for Pie and Line Charts
	 */
	public CompletableFuture<X_AD_PrintFormatItem> Data_PrintFormatItem(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getData_PrintFormatItem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormatItem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatItemDataLoader.DATALOADER_AD_PrintFormatItem_BY_ID);
		return dataLoader.load(entity.getData_PrintFormatItem_ID());
	}


	/**
	 * Get Data Column 2.
	 *
	 * @return Data Column for Line Charts
	 */
	public CompletableFuture<X_AD_PrintFormatItem> Data1_PrintFormatItem(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getData1_PrintFormatItem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormatItem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatItemDataLoader.DATALOADER_AD_PrintFormatItem_BY_ID);
		return dataLoader.load(entity.getData1_PrintFormatItem_ID());
	}


	/**
	 * Get Data Column 3.
	 *
	 * @return Data Column for Line Charts
	 */
	public CompletableFuture<X_AD_PrintFormatItem> Data2_PrintFormatItem(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getData2_PrintFormatItem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormatItem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatItemDataLoader.DATALOADER_AD_PrintFormatItem_BY_ID);
		return dataLoader.load(entity.getData2_PrintFormatItem_ID());
	}


	/**
	 * Get Data Column 4.
	 *
	 * @return Data Column for Line Charts
	 */
	public CompletableFuture<X_AD_PrintFormatItem> Data3_PrintFormatItem(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getData3_PrintFormatItem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormatItem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatItemDataLoader.DATALOADER_AD_PrintFormatItem_BY_ID);
		return dataLoader.load(entity.getData3_PrintFormatItem_ID());
	}


	/**
	 * Get Data Column 5.
	 *
	 * @return Data Column for Line Charts
	 */
	public CompletableFuture<X_AD_PrintFormatItem> Data4_PrintFormatItem(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getData4_PrintFormatItem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormatItem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatItemDataLoader.DATALOADER_AD_PrintFormatItem_BY_ID);
		return dataLoader.load(entity.getData4_PrintFormatItem_ID());
	}


	/**
	 * Get Description Column.
	 *
	 * @return Description Column for Pie/Line/Bar Charts
	 */
	public CompletableFuture<X_AD_PrintFormatItem> Description_PrintFormatItem(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (entity.getDescription_PrintFormatItem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormatItem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatItemDataLoader.DATALOADER_AD_PrintFormatItem_BY_ID);
		return dataLoader.load(entity.getDescription_PrintFormatItem_ID());
	}

	static Map<String, String> GRAPHTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "fcb7a61a-0a50-4b34-81c0-2fa928e81b9b");
			put("L", "fd92fba9-2a1e-409f-9112-16926a51006e");
			put("B", "eacbdb95-e916-43aa-a3a1-29916173a3be");
		}
	};
	public CompletableFuture<MRefList_BH> GraphType(X_AD_PrintGraph entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getGraphType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(GRAPHTYPE_UUIDS_BY_VALUE.get(entity.getGraphType()));
	}

}
