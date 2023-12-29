package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Reval_Index;

/**
 * Data Loader for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_IndexDataLoader extends PODataLoader<X_A_Asset_Reval_Index> {
	public static String A_Asset_Reval_Index_BY_ID_DATA_LOADER = "A_Asset_Reval_IndexByIdDataLoader";
	public static String A_Asset_Reval_Index_BY_UUID_DATA_LOADER = "A_Asset_Reval_IndexByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_Index.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Reval_Index_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Reval_Index_BY_UUID_DATA_LOADER;
	}
}
