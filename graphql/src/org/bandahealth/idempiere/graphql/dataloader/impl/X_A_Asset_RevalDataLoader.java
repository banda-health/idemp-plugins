package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetReval;

/**
 * Data Loader for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_RevalDataLoader extends PODataLoader<MAssetReval> {
	public static String DATALOADER_A_Asset_Reval_BY_ID = "A_Asset_RevalByIdDataLoader";
	public static String DATALOADER_A_Asset_Reval_BY_UUID = "A_Asset_RevalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetReval.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Reval_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Reval_BY_UUID;
	}
}
