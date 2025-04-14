package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLocation;

/**
 * Data Loader for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_LocationDataLoader extends PODataLoader<MLocation> {
	public static String DATALOADER_C_Location_BY_ID = "C_LocationByIdDataLoader";
	public static String DATALOADER_C_Location_BY_UUID = "C_LocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Location_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Location_BY_UUID;
	}
}
