package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Field;

/**
 * Data Loader for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_FieldDataLoader extends PODataLoader<X_ASP_Field> {
	public static String DATALOADER_ASP_Field_BY_ID = "ASP_FieldByIdDataLoader";
	public static String DATALOADER_ASP_Field_BY_UUID = "ASP_FieldByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Field.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Field_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Field_BY_UUID;
	}
}
