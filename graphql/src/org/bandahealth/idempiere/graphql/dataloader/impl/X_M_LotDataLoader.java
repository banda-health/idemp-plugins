package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLot;

/**
 * Data Loader for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotDataLoader extends PODataLoader<MLot> {
	public static String DATALOADER_M_Lot_BY_ID = "M_LotByIdDataLoader";
	public static String DATALOADER_M_Lot_BY_UUID = "M_LotByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLot.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Lot_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Lot_BY_UUID;
	}
}
