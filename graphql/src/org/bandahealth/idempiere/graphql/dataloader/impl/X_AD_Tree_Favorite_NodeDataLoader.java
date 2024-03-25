package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTreeFavoriteNode;

/**
 * Data Loader for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Tree_Favorite_NodeDataLoader extends PODataLoader<MTreeFavoriteNode> {
	public static String DATALOADER_AD_Tree_Favorite_Node_BY_ID = "AD_Tree_Favorite_NodeByIdDataLoader";
	public static String DATALOADER_AD_Tree_Favorite_Node_BY_UUID = "AD_Tree_Favorite_NodeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTreeFavoriteNode.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Tree_Favorite_Node_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Tree_Favorite_Node_BY_UUID;
	}
}
