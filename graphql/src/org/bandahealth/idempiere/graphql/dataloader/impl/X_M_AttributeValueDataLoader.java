package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttributeValue;

/**
 * Data Loader for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeValueDataLoader extends PODataLoader<MAttributeValue> {
	public static String DATALOADER_M_AttributeValue_BY_ID = "M_AttributeValueByIdDataLoader";
	public static String DATALOADER_M_AttributeValue_BY_UUID = "M_AttributeValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttributeValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_AttributeValue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_AttributeValue_BY_UUID;
	}
}
