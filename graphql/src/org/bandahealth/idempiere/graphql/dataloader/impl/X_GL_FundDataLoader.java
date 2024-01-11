package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_Fund;

/**
 * Data Loader for GL_Fund - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_FundDataLoader extends PODataLoader<X_GL_Fund> {
	public static String GL_Fund_BY_ID_DATA_LOADER = "GL_FundByIdDataLoader";
	public static String GL_Fund_BY_UUID_DATA_LOADER = "GL_FundByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_Fund.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_Fund_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_Fund_BY_UUID_DATA_LOADER;
	}
}
