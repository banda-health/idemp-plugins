package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefField;

/**
 * Data Loader for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_FieldDataLoader extends PODataLoader<MUserDefField> {
	public static String DATALOADER_AD_UserDef_Field_BY_ID = "AD_UserDef_FieldByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Field_BY_UUID = "AD_UserDef_FieldByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefField.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Field_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Field_BY_UUID;
	}
}
