package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_IMP_Processor_Type;

/**
 * Data Loader for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_Processor_TypeDataLoader extends PODataLoader<X_IMP_Processor_Type> {
	public static String IMP_Processor_Type_BY_ID_DATA_LOADER = "IMP_Processor_TypeByIdDataLoader";
	public static String IMP_Processor_Type_BY_UUID_DATA_LOADER = "IMP_Processor_TypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_IMP_Processor_Type.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return IMP_Processor_Type_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return IMP_Processor_Type_BY_UUID_DATA_LOADER;
	}
}
