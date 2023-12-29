package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetReval;

/**
 * Data Loader for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_RevalDataLoader extends PODataLoader<MAssetReval> {
	public static String A_Asset_Reval_BY_ID_DATA_LOADER = "A_Asset_RevalByIdDataLoader";
	public static String A_Asset_Reval_BY_UUID_DATA_LOADER = "A_Asset_RevalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetReval.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Reval_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Reval_BY_UUID_DATA_LOADER;
	}
}
