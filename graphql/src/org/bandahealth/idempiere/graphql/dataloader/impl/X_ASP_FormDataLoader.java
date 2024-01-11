package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Form;

/**
 * Data Loader for ASP_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_FormDataLoader extends PODataLoader<X_ASP_Form> {
	public static String ASP_Form_BY_ID_DATA_LOADER = "ASP_FormByIdDataLoader";
	public static String ASP_Form_BY_UUID_DATA_LOADER = "ASP_FormByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Form.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Form_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Form_BY_UUID_DATA_LOADER;
	}
}
