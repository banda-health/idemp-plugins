package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_ProcessorLog;

/**
 * Data Loader for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_IMP_ProcessorLogDataLoader extends PODataLoader<X_IMP_ProcessorLog> {
	public static String DATALOADER_IMP_ProcessorLog_BY_ID = "IMP_ProcessorLogByIdDataLoader";
	public static String DATALOADER_IMP_ProcessorLog_BY_UUID = "IMP_ProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_ProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_IMP_ProcessorLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_IMP_ProcessorLog_BY_UUID;
	}
}
