package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_Processor;

/**
 * Data Loader for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorDataLoader extends PODataLoader<X_IMP_Processor> {
	public static String DATALOADER_IMP_Processor_BY_ID = "IMP_ProcessorByIdDataLoader";
	public static String DATALOADER_IMP_Processor_BY_UUID = "IMP_ProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_Processor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_IMP_Processor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_IMP_Processor_BY_UUID;
	}
}
