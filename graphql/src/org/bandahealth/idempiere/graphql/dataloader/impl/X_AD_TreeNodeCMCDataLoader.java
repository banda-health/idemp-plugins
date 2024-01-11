package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeCMC;

/**
 * Data Loader for AD_TreeNodeCMC - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMCDataLoader extends PODataLoader<MTree_NodeCMC> {
	public static String AD_TreeNodeCMC_BY_ID_DATA_LOADER = "AD_TreeNodeCMCByIdDataLoader";
	public static String AD_TreeNodeCMC_BY_UUID_DATA_LOADER = "AD_TreeNodeCMCByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeCMC.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodeCMC_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodeCMC_BY_UUID_DATA_LOADER;
	}
}
