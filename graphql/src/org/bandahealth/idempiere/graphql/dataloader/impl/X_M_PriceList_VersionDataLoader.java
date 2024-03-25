package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPriceListVersion;

/**
 * Data Loader for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PriceList_VersionDataLoader extends PODataLoader<MPriceListVersion> {
	public static String DATALOADER_M_PriceList_Version_BY_ID = "M_PriceList_VersionByIdDataLoader";
	public static String DATALOADER_M_PriceList_Version_BY_UUID = "M_PriceList_VersionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPriceListVersion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PriceList_Version_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PriceList_Version_BY_UUID;
	}
}
