package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTreeFavorite;

/**
 * Data Loader for AD_Tree_Favorite - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Tree_FavoriteDataLoader extends PODataLoader<MTreeFavorite> {
	public static String AD_Tree_Favorite_BY_ID_DATA_LOADER = "AD_Tree_FavoriteByIdDataLoader";
	public static String AD_Tree_Favorite_BY_UUID_DATA_LOADER = "AD_Tree_FavoriteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTreeFavorite.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Tree_Favorite_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Tree_Favorite_BY_UUID_DATA_LOADER;
	}
}
