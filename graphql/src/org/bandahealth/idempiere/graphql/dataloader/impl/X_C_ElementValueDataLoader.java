package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MElementValue;

/**
 * Data Loader for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementValueDataLoader extends PODataLoader<MElementValue> {
	public static String C_ElementValue_BY_ID_DATA_LOADER = "C_ElementValueByIdDataLoader";
	public static String C_ElementValue_BY_UUID_DATA_LOADER = "C_ElementValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MElementValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ElementValue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ElementValue_BY_UUID_DATA_LOADER;
	}
}
