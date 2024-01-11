package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Field;

/**
 * Data Loader for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_FieldDataLoader extends PODataLoader<X_ASP_Field> {
	public static String ASP_Field_BY_ID_DATA_LOADER = "ASP_FieldByIdDataLoader";
	public static String ASP_Field_BY_UUID_DATA_LOADER = "ASP_FieldByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Field.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Field_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Field_BY_UUID_DATA_LOADER;
	}
}
