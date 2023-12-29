package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLot;

/**
 * Data Loader for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotDataLoader extends PODataLoader<MLot> {
	public static String M_Lot_BY_ID_DATA_LOADER = "M_LotByIdDataLoader";
	public static String M_Lot_BY_UUID_DATA_LOADER = "M_LotByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLot.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Lot_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Lot_BY_UUID_DATA_LOADER;
	}
}
