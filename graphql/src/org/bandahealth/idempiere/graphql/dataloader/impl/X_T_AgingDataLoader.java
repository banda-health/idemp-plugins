package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAging;

/**
 * Data Loader for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_AgingDataLoader extends PODataLoader<MAging> {
	public static String T_Aging_BY_ID_DATA_LOADER = "T_AgingByIdDataLoader";
	public static String T_Aging_BY_UUID_DATA_LOADER = "T_AgingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAging.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_Aging_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_Aging_BY_UUID_DATA_LOADER;
	}
}
