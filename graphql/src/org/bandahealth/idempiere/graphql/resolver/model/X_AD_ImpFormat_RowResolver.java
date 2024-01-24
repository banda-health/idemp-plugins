package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImpFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.X_AD_ImpFormat;
import org.compiere.model.X_AD_ImpFormat_Row;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImpFormat_RowResolver extends POResolver<X_AD_ImpFormat_Row> implements GraphQLResolver<X_AD_ImpFormat_Row> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_ImpFormat_Row entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Import Format.
	 *
	 * @return Import Format
	 */
	public CompletableFuture<X_AD_ImpFormat> AD_ImpFormat(X_AD_ImpFormat_Row entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ImpFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_ImpFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImpFormatDataLoader.DATALOADER_AD_ImpFormat_BY_ID);
		return dataLoader.load(entity.getAD_ImpFormat_ID());
	}

	static Map<String, String> DATATYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "9c5f2acd-b1fb-4a75-9639-ebe2bb41f06a");
			put("N", "af08143b-df3b-476f-8ca6-0ea9f93a2358");
			put("D", "72d8d47c-60ed-43fc-b72a-97d4f033e639");
			put("C", "6d62b598-f1c6-4a41-84a3-c4710f3c99ef");
		}
	};
	public CompletableFuture<MRefList_BH> DataType(X_AD_ImpFormat_Row entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDataType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(DATATYPE_UUIDS_BY_VALUE.get(entity.getDataType()));
	}

	public Boolean DivideBy100(X_AD_ImpFormat_Row entity, DataFetchingEnvironment environment) {
		return entity.isDivideBy100();
	}

}
