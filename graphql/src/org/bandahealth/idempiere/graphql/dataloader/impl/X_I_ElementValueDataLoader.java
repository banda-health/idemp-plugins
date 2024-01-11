package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_ElementValue;

/**
 * Data Loader for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ElementValueDataLoader extends PODataLoader<X_I_ElementValue> {
	public static String I_ElementValue_BY_ID_DATA_LOADER = "I_ElementValueByIdDataLoader";
	public static String I_ElementValue_BY_UUID_DATA_LOADER = "I_ElementValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_ElementValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_ElementValue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_ElementValue_BY_UUID_DATA_LOADER;
	}
}
