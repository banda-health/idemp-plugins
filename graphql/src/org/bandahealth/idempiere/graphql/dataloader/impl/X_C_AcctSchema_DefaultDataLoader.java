package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchemaDefault;

/**
 * Data Loader for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchema_DefaultDataLoader extends PODataLoader<MAcctSchemaDefault> {
	public static String DATALOADER_C_AcctSchema_Default_BY_ID = "C_AcctSchema_DefaultByIdDataLoader";
	public static String DATALOADER_C_AcctSchema_Default_BY_UUID = "C_AcctSchema_DefaultByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchemaDefault.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AcctSchema_Default_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AcctSchema_Default_BY_UUID;
	}
}
