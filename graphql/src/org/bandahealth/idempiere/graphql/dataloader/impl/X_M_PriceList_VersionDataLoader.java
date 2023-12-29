package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPriceListVersion;

/**
 * Data Loader for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceList_VersionDataLoader extends PODataLoader<MPriceListVersion> {
	public static String M_PriceList_Version_BY_ID_DATA_LOADER = "M_PriceList_VersionByIdDataLoader";
	public static String M_PriceList_Version_BY_UUID_DATA_LOADER = "M_PriceList_VersionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPriceListVersion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PriceList_Version_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PriceList_Version_BY_UUID_DATA_LOADER;
	}
}
