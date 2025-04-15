package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestUpdate;

/**
 * Data Loader for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestUpdateDataLoader extends PODataLoader<MRequestUpdate> {
	public static String DATALOADER_R_RequestUpdate_BY_ID = "R_RequestUpdateByIdDataLoader";
	public static String DATALOADER_R_RequestUpdate_BY_UUID = "R_RequestUpdateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestUpdate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestUpdate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestUpdate_BY_UUID;
	}
}
