package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPProcessor;

/**
 * Data Loader for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_ProcessorDataLoader extends PODataLoader<MEXPProcessor> {
	public static String DATALOADER_EXP_Processor_BY_ID = "EXP_ProcessorByIdDataLoader";
	public static String DATALOADER_EXP_Processor_BY_UUID = "EXP_ProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_EXP_Processor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_EXP_Processor_BY_UUID;
	}
}
