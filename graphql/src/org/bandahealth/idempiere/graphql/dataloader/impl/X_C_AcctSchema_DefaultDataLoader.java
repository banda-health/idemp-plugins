package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchemaDefault;

/**
 * Data Loader for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_DefaultDataLoader extends PODataLoader<MAcctSchemaDefault> {
	public static String C_AcctSchema_Default_BY_ID_DATA_LOADER = "C_AcctSchema_DefaultByIdDataLoader";
	public static String C_AcctSchema_Default_BY_UUID_DATA_LOADER = "C_AcctSchema_DefaultByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchemaDefault.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AcctSchema_Default_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AcctSchema_Default_BY_UUID_DATA_LOADER;
	}
}
