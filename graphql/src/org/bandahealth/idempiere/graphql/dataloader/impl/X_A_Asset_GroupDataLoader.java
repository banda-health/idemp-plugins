package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetGroup;

/**
 * Data Loader for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupDataLoader extends PODataLoader<MAssetGroup> {
	public static String A_Asset_Group_BY_ID_DATA_LOADER = "A_Asset_GroupByIdDataLoader";
	public static String A_Asset_Group_BY_UUID_DATA_LOADER = "A_Asset_GroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Group_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Group_BY_UUID_DATA_LOADER;
	}
}
