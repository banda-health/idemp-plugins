package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTreeFavorite;

/**
 * Data Loader for AD_Tree_Favorite - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Tree_FavoriteDataLoader extends PODataLoader<MTreeFavorite> {
	public static String DATALOADER_AD_Tree_Favorite_BY_ID = "AD_Tree_FavoriteByIdDataLoader";
	public static String DATALOADER_AD_Tree_Favorite_BY_UUID = "AD_Tree_FavoriteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTreeFavorite.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Tree_Favorite_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Tree_Favorite_BY_UUID;
	}
}
