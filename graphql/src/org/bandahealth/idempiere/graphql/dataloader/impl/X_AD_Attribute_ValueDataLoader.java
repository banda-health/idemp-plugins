package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Attribute_Value;

/**
 * Data Loader for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Attribute_ValueDataLoader extends PODataLoader<X_AD_Attribute_Value> {
	public static String AD_Attribute_Value_BY_ID_DATA_LOADER = "AD_Attribute_ValueByIdDataLoader";
	public static String AD_Attribute_Value_BY_UUID_DATA_LOADER = "AD_Attribute_ValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Attribute_Value.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Attribute_Value_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Attribute_Value_BY_UUID_DATA_LOADER;
	}
}
