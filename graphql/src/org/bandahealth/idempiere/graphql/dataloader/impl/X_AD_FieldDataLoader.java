package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MField_BH;

/**
 * Data Loader for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FieldDataLoader extends PODataLoader<MField_BH> {
	public static String AD_Field_BY_ID_DATA_LOADER = "AD_FieldByIdDataLoader";
	public static String AD_Field_BY_UUID_DATA_LOADER = "AD_FieldByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MField_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Field_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Field_BY_UUID_DATA_LOADER;
	}
}
