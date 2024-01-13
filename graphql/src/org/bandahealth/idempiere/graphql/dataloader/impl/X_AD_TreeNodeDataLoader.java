package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_Node;

/**
 * Data Loader for AD_TreeNode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeDataLoader extends PODataLoader<MTree_Node> {
	public static String DATALOADER_AD_TreeNode_BY_ID = "AD_TreeNodeByIdDataLoader";
	public static String DATALOADER_AD_TreeNode_BY_UUID = "AD_TreeNodeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_Node.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNode_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNode_BY_UUID;
	}
}
