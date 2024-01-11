package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Attribute;

/**
 * Data Loader for AD_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AttributeDataLoader extends PODataLoader<X_AD_Attribute> {
	public static String AD_Attribute_BY_ID_DATA_LOADER = "AD_AttributeByIdDataLoader";
	public static String AD_Attribute_BY_UUID_DATA_LOADER = "AD_AttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Attribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Attribute_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Attribute_BY_UUID_DATA_LOADER;
	}
}
