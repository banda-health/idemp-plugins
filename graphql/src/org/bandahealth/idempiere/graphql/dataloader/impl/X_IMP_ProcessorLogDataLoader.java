package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIMPProcessorLog;

/**
 * Data Loader for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorLogDataLoader extends PODataLoader<MIMPProcessorLog> {
	public static String DATALOADER_IMP_ProcessorLog_BY_ID = "IMP_ProcessorLogByIdDataLoader";
	public static String DATALOADER_IMP_ProcessorLog_BY_UUID = "IMP_ProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIMPProcessorLog.Table_Name;
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
