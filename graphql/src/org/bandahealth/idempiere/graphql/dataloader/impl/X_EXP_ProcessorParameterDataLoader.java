package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPProcessorParameter;

/**
 * Data Loader for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_ProcessorParameterDataLoader extends PODataLoader<MEXPProcessorParameter> {
	public static String EXP_ProcessorParameter_BY_ID_DATA_LOADER = "EXP_ProcessorParameterByIdDataLoader";
	public static String EXP_ProcessorParameter_BY_UUID_DATA_LOADER = "EXP_ProcessorParameterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPProcessorParameter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return EXP_ProcessorParameter_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return EXP_ProcessorParameter_BY_UUID_DATA_LOADER;
	}
}
