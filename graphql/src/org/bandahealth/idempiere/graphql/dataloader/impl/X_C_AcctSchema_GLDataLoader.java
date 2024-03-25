package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchemaGL;

/**
 * Data Loader for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchema_GLDataLoader extends PODataLoader<MAcctSchemaGL> {
	public static String DATALOADER_C_AcctSchema_GL_BY_ID = "C_AcctSchema_GLByIdDataLoader";
	public static String DATALOADER_C_AcctSchema_GL_BY_UUID = "C_AcctSchema_GLByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchemaGL.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AcctSchema_GL_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AcctSchema_GL_BY_UUID;
	}
}
