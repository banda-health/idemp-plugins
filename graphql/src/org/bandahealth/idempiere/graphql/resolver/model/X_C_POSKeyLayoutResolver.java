package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSKeyLayoutResolver extends POResolver<MPOSKeyLayout> implements GraphQLResolver<MPOSKeyLayout> {



	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(MPOSKeyLayout entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.DATALOADER_AD_PrintColor_BY_ID);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}


	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	public CompletableFuture<X_AD_PrintFont> AD_PrintFont(MPOSKeyLayout entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.DATALOADER_AD_PrintFont_BY_ID);
		return dataLoader.load(entity.getAD_PrintFont_ID());
	}

	static Map<String, String> POSKEYLAYOUTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("K", "2740bb60-24ef-4fd4-a741-77440c9ed491");
			put("N", "518e5b11-cbc2-42bd-b21e-6b66e040d9eb");
			put("P", "b52db13f-965c-4a2b-9f23-12576332795a");
		}
	};
	public CompletableFuture<MRefList_BH> POSKeyLayoutType(MPOSKeyLayout entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPOSKeyLayoutType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSKEYLAYOUTTYPE_UUIDS_BY_VALUE.get(entity.getPOSKeyLayoutType()));
	}

}
