package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeMM;

/**
 * Data Loader for AD_TreeNodeMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeMMDataLoader extends PODataLoader<MTree_NodeMM> {
	public static String AD_TreeNodeMM_BY_ID_DATA_LOADER = "AD_TreeNodeMMByIdDataLoader";
	public static String AD_TreeNodeMM_BY_UUID_DATA_LOADER = "AD_TreeNodeMMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeMM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodeMM_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodeMM_BY_UUID_DATA_LOADER;
	}
}
