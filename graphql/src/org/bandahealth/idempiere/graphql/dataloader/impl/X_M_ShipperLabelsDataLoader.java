package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipperLabels;

/**
 * Data Loader for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperLabelsDataLoader extends PODataLoader<MShipperLabels> {
	public static String M_ShipperLabels_BY_ID_DATA_LOADER = "M_ShipperLabelsByIdDataLoader";
	public static String M_ShipperLabels_BY_UUID_DATA_LOADER = "M_ShipperLabelsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipperLabels.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShipperLabels_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShipperLabels_BY_UUID_DATA_LOADER;
	}
}
