package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetTransfer;

/**
 * Data Loader for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_TransferDataLoader extends PODataLoader<MAssetTransfer> {
	public static String A_Asset_Transfer_BY_ID_DATA_LOADER = "A_Asset_TransferByIdDataLoader";
	public static String A_Asset_Transfer_BY_UUID_DATA_LOADER = "A_Asset_TransferByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetTransfer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Transfer_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Transfer_BY_UUID_DATA_LOADER;
	}
}
