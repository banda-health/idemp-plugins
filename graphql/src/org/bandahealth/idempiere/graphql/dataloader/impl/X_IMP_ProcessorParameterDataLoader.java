package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_ProcessorParameter;

/**
 * Data Loader for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorParameterDataLoader extends PODataLoader<X_IMP_ProcessorParameter> {
	public static String IMP_ProcessorParameter_BY_ID_DATA_LOADER = "IMP_ProcessorParameterByIdDataLoader";
	public static String IMP_ProcessorParameter_BY_UUID_DATA_LOADER = "IMP_ProcessorParameterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_ProcessorParameter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return IMP_ProcessorParameter_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return IMP_ProcessorParameter_BY_UUID_DATA_LOADER;
	}
}
