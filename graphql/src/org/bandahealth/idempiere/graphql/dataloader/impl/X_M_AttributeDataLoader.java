package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttribute;

/**
 * Data Loader for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeDataLoader extends PODataLoader<MAttribute> {
	public static String DATALOADER_M_Attribute_BY_ID = "M_AttributeByIdDataLoader";
	public static String DATALOADER_M_Attribute_BY_UUID = "M_AttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Attribute_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Attribute_BY_UUID;
	}
}
