package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Attribute;

/**
 * Data Loader for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_AttributeDataLoader extends PODataLoader<X_HR_Attribute> {
	public static String DATALOADER_HR_Attribute_BY_ID = "HR_AttributeByIdDataLoader";
	public static String DATALOADER_HR_Attribute_BY_UUID = "HR_AttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Attribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Attribute_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Attribute_BY_UUID;
	}
}
