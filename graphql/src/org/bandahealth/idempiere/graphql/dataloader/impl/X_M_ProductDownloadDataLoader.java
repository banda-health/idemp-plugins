package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductDownload;

/**
 * Data Loader for M_ProductDownload - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ProductDownloadDataLoader extends PODataLoader<MProductDownload> {
	public static String DATALOADER_M_ProductDownload_BY_ID = "M_ProductDownloadByIdDataLoader";
	public static String DATALOADER_M_ProductDownload_BY_UUID = "M_ProductDownloadByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductDownload.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ProductDownload_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ProductDownload_BY_UUID;
	}
}
