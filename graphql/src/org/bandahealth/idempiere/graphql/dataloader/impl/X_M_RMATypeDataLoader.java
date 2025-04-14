package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_RMAType;

/**
 * Data Loader for M_RMAType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_RMATypeDataLoader extends PODataLoader<X_M_RMAType> {
	public static String DATALOADER_M_RMAType_BY_ID = "M_RMATypeByIdDataLoader";
	public static String DATALOADER_M_RMAType_BY_UUID = "M_RMATypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_RMAType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_RMAType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_RMAType_BY_UUID;
	}
}
