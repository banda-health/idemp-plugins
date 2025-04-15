package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MElementValue;

/**
 * Data Loader for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ElementValueDataLoader extends PODataLoader<MElementValue> {
	public static String DATALOADER_C_ElementValue_BY_ID = "C_ElementValueByIdDataLoader";
	public static String DATALOADER_C_ElementValue_BY_UUID = "C_ElementValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MElementValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ElementValue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ElementValue_BY_UUID;
	}
}
