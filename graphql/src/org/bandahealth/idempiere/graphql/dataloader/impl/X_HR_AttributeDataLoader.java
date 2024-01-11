package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Attribute;

/**
 * Data Loader for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_AttributeDataLoader extends PODataLoader<X_HR_Attribute> {
	public static String HR_Attribute_BY_ID_DATA_LOADER = "HR_AttributeByIdDataLoader";
	public static String HR_Attribute_BY_UUID_DATA_LOADER = "HR_AttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Attribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Attribute_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Attribute_BY_UUID_DATA_LOADER;
	}
}
