package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Attribute;

/**
 * Data Loader for AD_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AttributeDataLoader extends PODataLoader<X_AD_Attribute> {
	public static String DATALOADER_AD_Attribute_BY_ID = "AD_AttributeByIdDataLoader";
	public static String DATALOADER_AD_Attribute_BY_UUID = "AD_AttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Attribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Attribute_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Attribute_BY_UUID;
	}
}
