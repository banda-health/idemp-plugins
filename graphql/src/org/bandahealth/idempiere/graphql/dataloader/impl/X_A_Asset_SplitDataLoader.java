package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Split;

/**
 * Data Loader for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_SplitDataLoader extends PODataLoader<X_A_Asset_Split> {
	public static String A_Asset_Split_BY_ID_DATA_LOADER = "A_Asset_SplitByIdDataLoader";
	public static String A_Asset_Split_BY_UUID_DATA_LOADER = "A_Asset_SplitByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Split.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Split_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Split_BY_UUID_DATA_LOADER;
	}
}
