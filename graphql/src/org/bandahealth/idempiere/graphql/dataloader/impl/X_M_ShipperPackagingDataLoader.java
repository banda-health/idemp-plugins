package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipperPackaging;

/**
 * Data Loader for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingDataLoader extends PODataLoader<MShipperPackaging> {
	public static String M_ShipperPackaging_BY_ID_DATA_LOADER = "M_ShipperPackagingByIdDataLoader";
	public static String M_ShipperPackaging_BY_UUID_DATA_LOADER = "M_ShipperPackagingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipperPackaging.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShipperPackaging_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShipperPackaging_BY_UUID_DATA_LOADER;
	}
}
