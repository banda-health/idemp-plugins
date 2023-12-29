package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MImage;
import org.compiere.model.MRefList;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintTableFormat;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintTableFormatResolver extends POResolver<X_AD_PrintTableFormat> implements GraphQLResolver<X_AD_PrintTableFormat> {



	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.AD_Image_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Image_ID());
	}


	/**
	 * Get Function Font.
	 *
	 * @return Function row Font
	 */
	public CompletableFuture<X_AD_PrintFont> Funct_PrintFont(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getFunct_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.AD_PrintFont_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getFunct_PrintFont_ID());
	}


	/**
	 * Get Function BG Color.
	 *
	 * @return Function Background Color
	 */
	public CompletableFuture<X_AD_PrintColor> FunctBG_PrintColor(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getFunctBG_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getFunctBG_PrintColor_ID());
	}


	/**
	 * Get Function Color.
	 *
	 * @return Function Foreground Color
	 */
	public CompletableFuture<X_AD_PrintColor> FunctFG_PrintColor(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getFunctFG_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getFunctFG_PrintColor_ID());
	}


	/**
	 * Get Header Row Font.
	 *
	 * @return Header row Font
	 */
	public CompletableFuture<X_AD_PrintFont> Hdr_PrintFont(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getHdr_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.AD_PrintFont_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHdr_PrintFont_ID());
	}


	/**
	 * Get Header Line Color.
	 *
	 * @return Table header row line color
	 */
	public CompletableFuture<X_AD_PrintColor> HdrLine_PrintColor(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getHdrLine_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHdrLine_PrintColor_ID());
	}

	static Map<String, String> HDRSTROKETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "9ad32e3a-041c-4b8f-a55d-0690f76aad33");
			put("D", "14819462-54d8-4253-aeb8-f6d21310f7ec");
			put("d", "6d0afb30-9ebc-4fa6-992b-493962dc04ec");
			put("2", "36c0e576-a4e4-4fb6-88ec-a5359f77c222");
		}
	};
	public CompletableFuture<MRefList> HdrStrokeType_RL(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getHdrStrokeType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(HDRSTROKETYPE_UUIDS_BY_VALUE.get(entity.getHdrStrokeType()));
	}


	/**
	 * Get Header Row BG Color.
	 *
	 * @return Background color of header row
	 */
	public CompletableFuture<X_AD_PrintColor> HdrTextBG_PrintColor(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getHdrTextBG_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHdrTextBG_PrintColor_ID());
	}


	/**
	 * Get Header Row Color.
	 *
	 * @return Foreground color if the table header row
	 */
	public CompletableFuture<X_AD_PrintColor> HdrTextFG_PrintColor(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getHdrTextFG_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHdrTextFG_PrintColor_ID());
	}


	/**
	 * Get Line Color.
	 *
	 * @return Table line color
	 */
	public CompletableFuture<X_AD_PrintColor> Line_PrintColor(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (entity.getLine_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getLine_PrintColor_ID());
	}

	static Map<String, String> LINESTROKETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "9ad32e3a-041c-4b8f-a55d-0690f76aad33");
			put("D", "14819462-54d8-4253-aeb8-f6d21310f7ec");
			put("d", "6d0afb30-9ebc-4fa6-992b-493962dc04ec");
			put("2", "36c0e576-a4e4-4fb6-88ec-a5359f77c222");
		}
	};
	public CompletableFuture<MRefList> LineStrokeType_RL(X_AD_PrintTableFormat entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLineStrokeType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(LINESTROKETYPE_UUIDS_BY_VALUE.get(entity.getLineStrokeType()));
	}

}
