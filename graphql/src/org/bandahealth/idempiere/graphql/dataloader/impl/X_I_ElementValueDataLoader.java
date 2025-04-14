package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_ElementValue;

/**
 * Data Loader for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_ElementValueDataLoader extends PODataLoader<X_I_ElementValue> {
	public static String DATALOADER_I_ElementValue_BY_ID = "I_ElementValueByIdDataLoader";
	public static String DATALOADER_I_ElementValue_BY_UUID = "I_ElementValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_ElementValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_ElementValue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_ElementValue_BY_UUID;
	}
}
