package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Form;

/**
 * Data Loader for ASP_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_FormDataLoader extends PODataLoader<X_ASP_Form> {
	public static String DATALOADER_ASP_Form_BY_ID = "ASP_FormByIdDataLoader";
	public static String DATALOADER_ASP_Form_BY_UUID = "ASP_FormByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Form.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Form_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Form_BY_UUID;
	}
}
