package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPProcessorParameter;

/**
 * Data Loader for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_ProcessorParameterDataLoader extends PODataLoader<MEXPProcessorParameter> {
	public static String DATALOADER_EXP_ProcessorParameter_BY_ID = "EXP_ProcessorParameterByIdDataLoader";
	public static String DATALOADER_EXP_ProcessorParameter_BY_UUID = "EXP_ProcessorParameterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPProcessorParameter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_EXP_ProcessorParameter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_EXP_ProcessorParameter_BY_UUID;
	}
}
