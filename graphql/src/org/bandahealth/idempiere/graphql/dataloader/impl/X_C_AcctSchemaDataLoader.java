package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchema;

/**
 * Data Loader for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchemaDataLoader extends PODataLoader<MAcctSchema> {
	public static String C_AcctSchema_BY_ID_DATA_LOADER = "C_AcctSchemaByIdDataLoader";
	public static String C_AcctSchema_BY_UUID_DATA_LOADER = "C_AcctSchemaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchema.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AcctSchema_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AcctSchema_BY_UUID_DATA_LOADER;
	}
}
