package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeCMS;

/**
 * Data Loader for AD_TreeNodeCMS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeCMSDataLoader extends PODataLoader<MTree_NodeCMS> {
	public static String DATALOADER_AD_TreeNodeCMS_BY_ID = "AD_TreeNodeCMSByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeCMS_BY_UUID = "AD_TreeNodeCMSByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeCMS.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMS_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMS_BY_UUID;
	}
}
