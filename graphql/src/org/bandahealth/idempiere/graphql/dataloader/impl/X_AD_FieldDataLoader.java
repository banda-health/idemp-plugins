package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MField_BH;

/**
 * Data Loader for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_FieldDataLoader extends PODataLoader<MField_BH> {
	public static String DATALOADER_AD_Field_BY_ID = "AD_FieldByIdDataLoader";
	public static String DATALOADER_AD_Field_BY_UUID = "AD_FieldByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MField_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Field_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Field_BY_UUID;
	}
}
