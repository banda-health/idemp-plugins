package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStorageReservation;

/**
 * Data Loader for M_StorageReservation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_StorageReservationDataLoader extends PODataLoader<MStorageReservation> {
	public static String DATALOADER_M_StorageReservation_BY_ID = "M_StorageReservationByIdDataLoader";
	public static String DATALOADER_M_StorageReservation_BY_UUID = "M_StorageReservationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStorageReservation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_StorageReservation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_StorageReservation_BY_UUID;
	}
}
