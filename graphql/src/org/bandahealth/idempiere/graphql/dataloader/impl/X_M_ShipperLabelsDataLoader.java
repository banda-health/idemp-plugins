package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShipperLabels;

/**
 * Data Loader for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperLabelsDataLoader extends PODataLoader<MShipperLabels> {
	public static String DATALOADER_M_ShipperLabels_BY_ID = "M_ShipperLabelsByIdDataLoader";
	public static String DATALOADER_M_ShipperLabels_BY_UUID = "M_ShipperLabelsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShipperLabels.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShipperLabels_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShipperLabels_BY_UUID;
	}
}
