package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipper;

/**
 * Data Loader for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShipperDataLoader extends PODataLoader<MShipper> {
	public static String DATALOADER_M_Shipper_BY_ID = "M_ShipperByIdDataLoader";
	public static String DATALOADER_M_Shipper_BY_UUID = "M_ShipperByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipper.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Shipper_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Shipper_BY_UUID;
	}
}
