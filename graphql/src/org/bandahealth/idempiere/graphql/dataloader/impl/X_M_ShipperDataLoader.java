package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipper;

/**
 * Data Loader for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperDataLoader extends PODataLoader<MShipper> {
	public static String M_Shipper_BY_ID_DATA_LOADER = "M_ShipperByIdDataLoader";
	public static String M_Shipper_BY_UUID_DATA_LOADER = "M_ShipperByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipper.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Shipper_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Shipper_BY_UUID_DATA_LOADER;
	}
}
