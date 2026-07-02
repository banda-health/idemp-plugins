package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;

/**
 * Data Loader for BH_SickOff_Print_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOff_Print_LogDataLoader extends PODataLoader<MBHSickOffPrintLog> {
	public static String DATALOADER_BH_SickOff_Print_Log_BY_ID = "BH_SickOff_Print_LogByIdDataLoader";
	public static String DATALOADER_BH_SickOff_Print_Log_BY_UUID = "BH_SickOff_Print_LogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHSickOffPrintLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_SickOff_Print_Log_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_SickOff_Print_Log_BY_UUID;
	}
}
