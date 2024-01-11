package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_ProcessorLog;

/**
 * Data Loader for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorLogDataLoader extends PODataLoader<X_IMP_ProcessorLog> {
	public static String IMP_ProcessorLog_BY_ID_DATA_LOADER = "IMP_ProcessorLogByIdDataLoader";
	public static String IMP_ProcessorLog_BY_UUID_DATA_LOADER = "IMP_ProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_ProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return IMP_ProcessorLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return IMP_ProcessorLog_BY_UUID_DATA_LOADER;
	}
}
