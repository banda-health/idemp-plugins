package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_Processor_Type;

/**
 * Data Loader for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_Processor_TypeDataLoader extends PODataLoader<X_IMP_Processor_Type> {
	public static String DATALOADER_IMP_Processor_Type_BY_ID = "IMP_Processor_TypeByIdDataLoader";
	public static String DATALOADER_IMP_Processor_Type_BY_UUID = "IMP_Processor_TypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_Processor_Type.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_IMP_Processor_Type_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_IMP_Processor_Type_BY_UUID;
	}
}
