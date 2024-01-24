package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLocatorType;

/**
 * Data Loader for M_LocatorType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LocatorTypeDataLoader extends PODataLoader<MLocatorType> {
	public static String DATALOADER_M_LocatorType_BY_ID = "M_LocatorTypeByIdDataLoader";
	public static String DATALOADER_M_LocatorType_BY_UUID = "M_LocatorTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLocatorType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_LocatorType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_LocatorType_BY_UUID;
	}
}
