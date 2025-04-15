package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetTransfer;

/**
 * Data Loader for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_TransferDataLoader extends PODataLoader<MAssetTransfer> {
	public static String DATALOADER_A_Asset_Transfer_BY_ID = "A_Asset_TransferByIdDataLoader";
	public static String DATALOADER_A_Asset_Transfer_BY_UUID = "A_Asset_TransferByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetTransfer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Transfer_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Transfer_BY_UUID;
	}
}
