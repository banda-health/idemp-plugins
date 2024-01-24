package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPProcessorType;

/**
 * Data Loader for EXP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_Processor_TypeDataLoader extends PODataLoader<MEXPProcessorType> {
	public static String DATALOADER_EXP_Processor_Type_BY_ID = "EXP_Processor_TypeByIdDataLoader";
	public static String DATALOADER_EXP_Processor_Type_BY_UUID = "EXP_Processor_TypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPProcessorType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_EXP_Processor_Type_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_EXP_Processor_Type_BY_UUID;
	}
}
