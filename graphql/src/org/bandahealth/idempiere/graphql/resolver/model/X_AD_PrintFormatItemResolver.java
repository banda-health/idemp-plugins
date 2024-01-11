package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatItem_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintGraphDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintFormatItem;
import org.compiere.model.X_AD_PrintGraph;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintFormatItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormatItemResolver extends POResolver<X_AD_PrintFormatItem> implements GraphQLResolver<X_AD_PrintFormatItem> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.AD_Column_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}


	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	public CompletableFuture<X_AD_PrintFont> AD_PrintFont(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.AD_PrintFont_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintFont_ID());
	}


	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Included Print Format.
	 *
	 * @return Print format that is included here.
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormatChild(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormatChild_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintFormatChild_ID());
	}


	/**
	 * Get Graph.
	 *
	 * @return Graph included in Reports
	 */
	public CompletableFuture<X_AD_PrintGraph> AD_PrintGraph(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintGraph_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintGraph> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintGraphDataLoader.AD_PrintGraph_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintGraph_ID());
	}

	static Map<String, String> BARCODETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("2o9", "3f894778-fd6e-432a-894d-f8539a14ef9b");
			put("3o9", "b73c1ee0-d996-49e3-b0cf-55124e39387b");
			put("COD", "827e8134-89ed-46a5-88ef-f4669c30f954");
			put("C28", "a2d41ecd-b728-4f76-9952-c115bc5fdd1a");
			put("28A", "a255e083-9bdc-4f5c-b275-df9fd97a063a");
			put("28B", "4e9a0071-9f64-4e16-a986-4bc58cfc4496");
			put("28C", "67af4f5e-4e57-4026-abcb-2b915e543e0f");
			put("C39", "29d97224-a341-4037-86c7-f662a6f72f92");
			put("E28", "721c0b8b-55f6-4763-8023-e8362713d914");
			put("GTN", "29566b39-b3e1-4ae1-876e-c94d0dd0f96e");
			put("MON", "54e16b0a-0981-42e3-a6cc-7818e8c11a51");
			put("NW7", "bda832d2-69ed-4232-b482-dfc6ff1e10b1");
			put("417", "1221c45c-362e-4ef4-90e0-8e4357edf26d");
			put("C14", "d0619169-204f-412a-9465-581a455b2deb");
			put("SID", "4ea7359f-51eb-4226-8097-4b75f9f17ace");
			put("U28", "72283256-cdfe-40df-beac-182b225e4cb3");
			put("US3", "ef3dc4b7-19eb-42f3-b5cb-fc5119742778");
			put("US4", "2fea861f-2559-4168-828d-f85e9cda65c9");
			put("USP", "e9dc3d20-df06-43dc-a4c8-01016c276c7e");
			put("C18", "82fca495-3a77-42da-9870-209029467b0b");
			put("us3", "d84e6445-e9c1-4888-8cc6-0cac2b704a9f");
			put("3O9", "8294c247-43f4-451b-8b4f-2a08d6987bdf");
			put("c39", "ff69d6db-99c6-4ec9-8d05-378bb2188561");
			put("E13", "8412f6f5-cfb2-4c4a-bc4e-36e9511f3077");
			put("UPA", "79d36566-b888-4fc1-931d-c0b1612c709b");
			put("39C", "af593ade-94ff-47bf-9b4e-a60c278d3541");
			put("39c", "918c6018-41f7-40ba-965b-65512ec99808");
			put("QRC", "702f344c-557a-4a34-aaae-578cb1b2d137");
		}
	};
	public CompletableFuture<MRefList_BH> BarcodeType(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBarcodeType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BARCODETYPE_UUIDS_BY_VALUE.get(entity.getBarcodeType()));
	}

	static Map<String, String> FIELDALIGNMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "fb4bf83f-f475-494d-b05e-11d947df8745");
			put("L", "aa391a73-05a2-47c1-9067-86657561f926");
			put("T", "b5653e03-3c70-477b-960d-236b446b5230");
			put("B", "e387e37b-24b9-4180-9d81-24e3bb8fe8b4");
			put("C", "357ba870-01ff-4a4d-9f04-08e248792a50");
		}
	};
	public CompletableFuture<MRefList_BH> FieldAlignmentType(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFieldAlignmentType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(FIELDALIGNMENTTYPE_UUIDS_BY_VALUE.get(entity.getFieldAlignmentType()));
	}

	public Boolean ImageIsAttached(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isImageIsAttached();
	}

	public Boolean IsAveraged(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isAveraged();
	}

	public Boolean IsCentrallyMaintained(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isCentrallyMaintained();
	}

	public Boolean IsCounted(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isCounted();
	}

	public Boolean IsDesc(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isDesc();
	}

	public Boolean IsDeviationCalc(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isDeviationCalc();
	}

	public Boolean IsFilledRectangle(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isFilledRectangle();
	}

	public Boolean IsFixedWidth(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isFixedWidth();
	}

	public Boolean IsGroupBy(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isGroupBy();
	}

	public Boolean IsHeightOneLine(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isHeightOneLine();
	}

	public Boolean IsImageField(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isImageField();
	}

	public Boolean IsMaxCalc(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isMaxCalc();
	}

	public Boolean IsMinCalc(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isMinCalc();
	}

	public Boolean IsNextLine(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isNextLine();
	}

	public Boolean IsNextPage(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isNextPage();
	}

	public Boolean IsOrderBy(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isOrderBy();
	}

	public Boolean IsPageBreak(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isPageBreak();
	}

	public Boolean IsPrintBarcodeText(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isPrintBarcodeText();
	}

	public Boolean IsPrinted(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsRelativePosition(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isRelativePosition();
	}

	public Boolean IsRunningTotal(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isRunningTotal();
	}

	public Boolean IsSetNLPosition(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isSetNLPosition();
	}

	public Boolean IsSummarized(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isSummarized();
	}

	public Boolean IsSuppressNull(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isSuppressNull();
	}

	public Boolean IsSuppressRepeats(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isSuppressRepeats();
	}

	public Boolean IsVarianceCalc(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		return entity.isVarianceCalc();
	}

	static Map<String, String> LINEALIGNMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "817f7667-ac5e-4f06-9286-cb5fcd7500f4");
			put("C", "a7696334-94b1-420e-82d0-81b4a4130827");
			put("T", "c6a8e831-d5c8-4150-b38f-07fca75f183b");
			put("X", "d15d9113-c597-418b-b2fd-3ac86d80b1be");
		}
	};
	public CompletableFuture<MRefList_BH> LineAlignmentType(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLineAlignmentType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(LINEALIGNMENTTYPE_UUIDS_BY_VALUE.get(entity.getLineAlignmentType()));
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintFormatItem_TrlDataLoader.AD_PrintFormatItem_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_PrintFormatItem.COLUMNNAME_Name));
	}

	static Map<String, String> PRINTAREATYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "58ad0741-cc69-4b1d-8c73-fed4abac57ab");
			put("H", "453becb3-0d93-4d12-ae75-78bebd1271a3");
			put("F", "7ed41277-2dbf-4a59-a03d-a8c6b2d9bb82");
		}
	};
	public CompletableFuture<MRefList_BH> PrintAreaType(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPrintAreaType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PRINTAREATYPE_UUIDS_BY_VALUE.get(entity.getPrintAreaType()));
	}

	static Map<String, String> PRINTFORMATTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("F", "2f32de41-43da-44b9-a360-3c65c9644a07");
			put("T", "85949ecf-7e07-440b-9e49-125b2da22ba4");
			put("P", "a0a30c2e-59e4-4b8d-bd5c-f400056ecb96");
			put("I", "b7f7000b-28ea-486e-896f-3f1e1f465b84");
			put("R", "c36c78b3-5c92-4e49-8156-dcb6dd2f0c44");
			put("L", "7b5271ce-5d8f-4068-be40-b589b704d4f8");
		}
	};
	public CompletableFuture<MRefList_BH> PrintFormatType(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPrintFormatType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PRINTFORMATTYPE_UUIDS_BY_VALUE.get(entity.getPrintFormatType()));
	}

	/**
	 * Get Print Text.
	 *
	 * @return The label text to be printed on a document or correspondence.
	 */
	public CompletableFuture<String> PrintName(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPrintName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintFormatItem_TrlDataLoader.AD_PrintFormatItem_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_PrintFormatItem.COLUMNNAME_PrintName));
	}

	/**
	 * Get Print Label Suffix.
	 *
	 * @return The label text to be printed on a document or correspondence after the field
	 */
	public CompletableFuture<String> PrintNameSuffix(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPrintNameSuffix);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintFormatItem_TrlDataLoader.AD_PrintFormatItem_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_PrintFormatItem.COLUMNNAME_PrintNameSuffix));
	}

	static Map<String, String> SHAPETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "f5310ecc-61bf-440f-ac20-76c5e8c43765");
			put("O", "9f681f40-42f2-4cfa-9f64-b3df716d0f1b");
			put("R", "74140b8d-c2ec-4e62-a010-58f342215d37");
			put("N", "ecd843d9-b9c6-44d8-932a-74233181f644");
		}
	};
	public CompletableFuture<MRefList_BH> ShapeType(X_AD_PrintFormatItem entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getShapeType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(SHAPETYPE_UUIDS_BY_VALUE.get(entity.getShapeType()));
	}

}
