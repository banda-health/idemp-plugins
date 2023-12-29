package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipperPickupTypes;

/**
 * Data Loader for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesDataLoader extends PODataLoader<MShipperPickupTypes> {
	public static String M_ShipperPickupTypes_BY_ID_DATA_LOADER = "M_ShipperPickupTypesByIdDataLoader";
	public static String M_ShipperPickupTypes_BY_UUID_DATA_LOADER = "M_ShipperPickupTypesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipperPickupTypes.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShipperPickupTypes_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShipperPickupTypes_BY_UUID_DATA_LOADER;
	}
}
