package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchema;

/**
 * Data Loader for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchemaDataLoader extends PODataLoader<MAcctSchema> {
	public static String DATALOADER_C_AcctSchema_BY_ID = "C_AcctSchemaByIdDataLoader";
	public static String DATALOADER_C_AcctSchema_BY_UUID = "C_AcctSchemaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchema.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AcctSchema_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AcctSchema_BY_UUID;
	}
}
