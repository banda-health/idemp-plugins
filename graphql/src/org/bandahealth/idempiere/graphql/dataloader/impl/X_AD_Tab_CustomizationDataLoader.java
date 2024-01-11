package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Tab_Customization;

/**
 * Data Loader for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Tab_CustomizationDataLoader extends PODataLoader<X_AD_Tab_Customization> {
	public static String AD_Tab_Customization_BY_ID_DATA_LOADER = "AD_Tab_CustomizationByIdDataLoader";
	public static String AD_Tab_Customization_BY_UUID_DATA_LOADER = "AD_Tab_CustomizationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Tab_Customization.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Tab_Customization_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Tab_Customization_BY_UUID_DATA_LOADER;
	}
}
