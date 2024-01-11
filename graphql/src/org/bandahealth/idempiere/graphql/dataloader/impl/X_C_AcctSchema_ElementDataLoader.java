package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchemaElement;

/**
 * Data Loader for C_AcctSchema_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_ElementDataLoader extends PODataLoader<MAcctSchemaElement> {
	public static String C_AcctSchema_Element_BY_ID_DATA_LOADER = "C_AcctSchema_ElementByIdDataLoader";
	public static String C_AcctSchema_Element_BY_UUID_DATA_LOADER = "C_AcctSchema_ElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchemaElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AcctSchema_Element_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AcctSchema_Element_BY_UUID_DATA_LOADER;
	}
}
