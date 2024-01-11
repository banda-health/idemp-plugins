package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTreeFavoriteNode;

/**
 * Data Loader for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Tree_Favorite_NodeDataLoader extends PODataLoader<MTreeFavoriteNode> {
	public static String AD_Tree_Favorite_Node_BY_ID_DATA_LOADER = "AD_Tree_Favorite_NodeByIdDataLoader";
	public static String AD_Tree_Favorite_Node_BY_UUID_DATA_LOADER = "AD_Tree_Favorite_NodeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTreeFavoriteNode.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Tree_Favorite_Node_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Tree_Favorite_Node_BY_UUID_DATA_LOADER;
	}
}
