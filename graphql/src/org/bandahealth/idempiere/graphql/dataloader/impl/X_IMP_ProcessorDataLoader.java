package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIMPProcessor;

/**
 * Data Loader for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorDataLoader extends PODataLoader<MIMPProcessor> {
	public static String DATALOADER_IMP_Processor_BY_ID = "IMP_ProcessorByIdDataLoader";
	public static String DATALOADER_IMP_Processor_BY_UUID = "IMP_ProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIMPProcessor.Table_Name;
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
