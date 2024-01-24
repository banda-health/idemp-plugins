package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ServiceLevelLine;

/**
 * Data Loader for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelLineDataLoader extends PODataLoader<X_C_ServiceLevelLine> {
	public static String DATALOADER_C_ServiceLevelLine_BY_ID = "C_ServiceLevelLineByIdDataLoader";
	public static String DATALOADER_C_ServiceLevelLine_BY_UUID = "C_ServiceLevelLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ServiceLevelLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ServiceLevelLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ServiceLevelLine_BY_UUID;
	}
}
