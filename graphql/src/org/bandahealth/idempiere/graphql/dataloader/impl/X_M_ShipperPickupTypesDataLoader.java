package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipperPickupTypes;

/**
 * Data Loader for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperPickupTypesDataLoader extends PODataLoader<MShipperPickupTypes> {
	public static String DATALOADER_M_ShipperPickupTypes_BY_ID = "M_ShipperPickupTypesByIdDataLoader";
	public static String DATALOADER_M_ShipperPickupTypes_BY_UUID = "M_ShipperPickupTypesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipperPickupTypes.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShipperPickupTypes_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShipperPickupTypes_BY_UUID;
	}
}
