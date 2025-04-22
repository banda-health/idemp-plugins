package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_ProcessorParameter;

/**
 * Data Loader for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorParameterDataLoader extends PODataLoader<X_IMP_ProcessorParameter> {
	public static String DATALOADER_IMP_ProcessorParameter_BY_ID = "IMP_ProcessorParameterByIdDataLoader";
	public static String DATALOADER_IMP_ProcessorParameter_BY_UUID = "IMP_ProcessorParameterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_ProcessorParameter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_IMP_ProcessorParameter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_IMP_ProcessorParameter_BY_UUID;
	}
}
