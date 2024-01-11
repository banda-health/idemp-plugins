package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeCMT;

/**
 * Data Loader for AD_TreeNodeCMT - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMTDataLoader extends PODataLoader<X_AD_TreeNodeCMT> {
	public static String AD_TreeNodeCMT_BY_ID_DATA_LOADER = "AD_TreeNodeCMTByIdDataLoader";
	public static String AD_TreeNodeCMT_BY_UUID_DATA_LOADER = "AD_TreeNodeCMTByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMT.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodeCMT_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodeCMT_BY_UUID_DATA_LOADER;
	}
}
