package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeMM;

/**
 * Data Loader for AD_TreeNodeMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeMMDataLoader extends PODataLoader<MTree_NodeMM> {
	public static String DATALOADER_AD_TreeNodeMM_BY_ID = "AD_TreeNodeMMByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeMM_BY_UUID = "AD_TreeNodeMMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeMM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeMM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeMM_BY_UUID;
	}
}
