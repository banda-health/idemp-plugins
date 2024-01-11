package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeCMS;

/**
 * Data Loader for AD_TreeNodeCMS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMSDataLoader extends PODataLoader<MTree_NodeCMS> {
	public static String AD_TreeNodeCMS_BY_ID_DATA_LOADER = "AD_TreeNodeCMSByIdDataLoader";
	public static String AD_TreeNodeCMS_BY_UUID_DATA_LOADER = "AD_TreeNodeCMSByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeCMS.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodeCMS_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodeCMS_BY_UUID_DATA_LOADER;
	}
}
