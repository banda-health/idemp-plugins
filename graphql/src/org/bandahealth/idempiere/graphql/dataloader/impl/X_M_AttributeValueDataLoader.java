package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeValue;

/**
 * Data Loader for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeValueDataLoader extends PODataLoader<MAttributeValue> {
	public static String M_AttributeValue_BY_ID_DATA_LOADER = "M_AttributeValueByIdDataLoader";
	public static String M_AttributeValue_BY_UUID_DATA_LOADER = "M_AttributeValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_AttributeValue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_AttributeValue_BY_UUID_DATA_LOADER;
	}
}
