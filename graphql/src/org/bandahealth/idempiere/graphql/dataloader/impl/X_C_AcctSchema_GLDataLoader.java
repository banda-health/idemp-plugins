package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctSchemaGL;

/**
 * Data Loader for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_GLDataLoader extends PODataLoader<MAcctSchemaGL> {
	public static String C_AcctSchema_GL_BY_ID_DATA_LOADER = "C_AcctSchema_GLByIdDataLoader";
	public static String C_AcctSchema_GL_BY_UUID_DATA_LOADER = "C_AcctSchema_GLByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctSchemaGL.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AcctSchema_GL_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AcctSchema_GL_BY_UUID_DATA_LOADER;
	}
}
