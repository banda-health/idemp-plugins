package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectLine;

/**
 * Data Loader for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectLineDataLoader extends PODataLoader<MProjectLine> {
	public static String DATALOADER_C_ProjectLine_BY_ID = "C_ProjectLineByIdDataLoader";
	public static String DATALOADER_C_ProjectLine_BY_UUID = "C_ProjectLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ProjectLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ProjectLine_BY_UUID;
	}
}
