package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectLine;

/**
 * Data Loader for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectLineDataLoader extends PODataLoader<MProjectLine> {
	public static String C_ProjectLine_BY_ID_DATA_LOADER = "C_ProjectLineByIdDataLoader";
	public static String C_ProjectLine_BY_UUID_DATA_LOADER = "C_ProjectLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ProjectLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ProjectLine_BY_UUID_DATA_LOADER;
	}
}
