package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MTree_BH;

/**
 * Data Loader for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeDataLoader extends PODataLoader<MTree_BH> {
	public static String AD_Tree_BY_ID_DATA_LOADER = "AD_TreeByIdDataLoader";
	public static String AD_Tree_BY_UUID_DATA_LOADER = "AD_TreeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Tree_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Tree_BY_UUID_DATA_LOADER;
	}
}
