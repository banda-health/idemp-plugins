package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStorageReservation;

/**
 * Data Loader for M_StorageReservation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_StorageReservationDataLoader extends PODataLoader<MStorageReservation> {
	public static String M_StorageReservation_BY_ID_DATA_LOADER = "M_StorageReservationByIdDataLoader";
	public static String M_StorageReservation_BY_UUID_DATA_LOADER = "M_StorageReservationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStorageReservation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_StorageReservation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_StorageReservation_BY_UUID_DATA_LOADER;
	}
}
