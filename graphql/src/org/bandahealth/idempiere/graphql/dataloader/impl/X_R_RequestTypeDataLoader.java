package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestType;

/**
 * Data Loader for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_RequestTypeDataLoader extends PODataLoader<MRequestType> {
	public static String DATALOADER_R_RequestType_BY_ID = "R_RequestTypeByIdDataLoader";
	public static String DATALOADER_R_RequestType_BY_UUID = "R_RequestTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestType_BY_UUID;
	}
}
