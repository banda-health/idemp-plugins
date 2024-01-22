package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAging;

/**
 * Data Loader for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_AgingDataLoader extends PODataLoader<MAging> {
	public static String DATALOADER_T_Aging_BY_ID = "T_AgingByIdDataLoader";
	public static String DATALOADER_T_Aging_BY_UUID = "T_AgingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAging.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_Aging_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_Aging_BY_UUID;
	}
}
