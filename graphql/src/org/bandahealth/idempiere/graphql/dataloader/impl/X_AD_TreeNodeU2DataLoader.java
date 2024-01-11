package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeU2;

/**
 * Data Loader for AD_TreeNodeU2 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeU2DataLoader extends PODataLoader<X_AD_TreeNodeU2> {
	public static String AD_TreeNodeU2_BY_ID_DATA_LOADER = "AD_TreeNodeU2ByIdDataLoader";
	public static String AD_TreeNodeU2_BY_UUID_DATA_LOADER = "AD_TreeNodeU2ByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU2.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodeU2_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodeU2_BY_UUID_DATA_LOADER;
	}
}
