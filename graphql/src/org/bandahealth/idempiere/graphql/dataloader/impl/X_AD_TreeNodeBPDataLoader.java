package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeBP;

/**
 * Data Loader for AD_TreeNodeBP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeBPDataLoader extends PODataLoader<MTree_NodeBP> {
	public static String AD_TreeNodeBP_BY_ID_DATA_LOADER = "AD_TreeNodeBPByIdDataLoader";
	public static String AD_TreeNodeBP_BY_UUID_DATA_LOADER = "AD_TreeNodeBPByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeBP.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodeBP_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodeBP_BY_UUID_DATA_LOADER;
	}
}
