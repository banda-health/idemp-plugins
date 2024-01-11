package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_FormatDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEXPFormat;
import org.compiere.model.MEXPFormatLine;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_FormatLineResolver extends POResolver<MEXPFormatLine> implements GraphQLResolver<MEXPFormatLine> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.AD_Column_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.AD_Reference_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Embedded Format.
	 *
	 * @return Embedded Format
	 */
	public CompletableFuture<MEXPFormat> EXP_EmbeddedFormat(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		if (entity.getEXP_EmbeddedFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MEXPFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_EXP_FormatDataLoader.EXP_Format_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEXP_EmbeddedFormat_ID());
	}


	/**
	 * Get Export Format.
	 *
	 * @return Export Format
	 */
	public CompletableFuture<MEXPFormat> EXP_Format(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		if (entity.getEXP_Format_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MEXPFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_EXP_FormatDataLoader.EXP_Format_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEXP_Format_ID());
	}

	public Boolean IsMandatory(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		return entity.isMandatory();
	}

	public Boolean IsPartUniqueIndex(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		return entity.isPartUniqueIndex();
	}

	static Map<String, String> TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "041d9d58-b0bf-457c-adf8-2ad92fe467f4");
			put("A", "e3be2468-3aa3-491f-b468-3f82d8ede9f6");
			put("M", "8b3a6ec5-85ec-44b1-97d3-eec6fe9e8733");
			put("R", "7f2d26ec-8709-476d-9b4b-fd81c15f0e97");
		}
	};
	public CompletableFuture<MRefList_BH> Type(MEXPFormatLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(TYPE_UUIDS_BY_VALUE.get(entity.getType()));
	}

}
