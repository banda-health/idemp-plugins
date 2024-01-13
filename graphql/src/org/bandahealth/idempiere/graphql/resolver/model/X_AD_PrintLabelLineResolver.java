package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LabelPrinterFunctionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintLabelDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintLabelLine_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.PO;
import org.compiere.model.X_AD_LabelPrinterFunction;
import org.compiere.model.X_AD_PrintLabel;
import org.compiere.model.X_AD_PrintLabelLine;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintLabelLineResolver extends POResolver<X_AD_PrintLabelLine> implements GraphQLResolver<X_AD_PrintLabelLine> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_PrintLabelLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Label printer Function.
	 *
	 * @return Function of Label Printer
	 */
	public CompletableFuture<X_AD_LabelPrinterFunction> AD_LabelPrinterFunction(X_AD_PrintLabelLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LabelPrinterFunction_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_LabelPrinterFunction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LabelPrinterFunctionDataLoader.DATALOADER_AD_LabelPrinterFunction_BY_ID);
		return dataLoader.load(entity.getAD_LabelPrinterFunction_ID());
	}


	/**
	 * Get Print Label.
	 *
	 * @return Label Format to print
	 */
	public CompletableFuture<X_AD_PrintLabel> AD_PrintLabel(X_AD_PrintLabelLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintLabel_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintLabel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintLabelDataLoader.DATALOADER_AD_PrintLabel_BY_ID);
		return dataLoader.load(entity.getAD_PrintLabel_ID());
	}

	static Map<String, String> LABELFORMATTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("F", "6c3c7cc6-db53-43ba-96e0-997cfe7adcfb");
			put("T", "57e49325-7b0d-406c-bf07-e87bf44e930e");
		}
	};
	public CompletableFuture<MRefList_BH> LabelFormatType(X_AD_PrintLabelLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLabelFormatType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(LABELFORMATTYPE_UUIDS_BY_VALUE.get(entity.getLabelFormatType()));
	}

	/**
	 * Get Print Text.
	 *
	 * @return The label text to be printed on a document or correspondence.
	 */
	public CompletableFuture<String> PrintName(X_AD_PrintLabelLine entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPrintName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintLabelLine_TrlDataLoader.DATALOADER_AD_PrintLabelLine_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_PrintLabelLine.COLUMNNAME_PrintName));
	}

}
