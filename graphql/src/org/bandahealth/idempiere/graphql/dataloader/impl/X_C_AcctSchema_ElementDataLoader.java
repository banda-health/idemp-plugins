package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchemaElement;

/**
 * Data Loader for C_AcctSchema_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_ElementDataLoader extends PODataLoader<MAcctSchemaElement> {
	public static String DATALOADER_C_AcctSchema_Element_BY_ID = "C_AcctSchema_ElementByIdDataLoader";
	public static String DATALOADER_C_AcctSchema_Element_BY_UUID = "C_AcctSchema_ElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchemaElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AcctSchema_Element_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AcctSchema_Element_BY_UUID;
	}
}
