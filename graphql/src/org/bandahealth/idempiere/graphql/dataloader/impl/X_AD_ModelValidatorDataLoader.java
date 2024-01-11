package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ModelValidator;

/**
 * Data Loader for AD_ModelValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ModelValidatorDataLoader extends PODataLoader<X_AD_ModelValidator> {
	public static String AD_ModelValidator_BY_ID_DATA_LOADER = "AD_ModelValidatorByIdDataLoader";
	public static String AD_ModelValidator_BY_UUID_DATA_LOADER = "AD_ModelValidatorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ModelValidator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ModelValidator_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ModelValidator_BY_UUID_DATA_LOADER;
	}
}
