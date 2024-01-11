package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_Node;

/**
 * Data Loader for AD_TreeNode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeDataLoader extends PODataLoader<MTree_Node> {
	public static String AD_TreeNode_BY_ID_DATA_LOADER = "AD_TreeNodeByIdDataLoader";
	public static String AD_TreeNode_BY_UUID_DATA_LOADER = "AD_TreeNodeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_Node.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNode_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNode_BY_UUID_DATA_LOADER;
	}
}
