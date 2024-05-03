package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_Fund;

/**
 * Data Loader for GL_Fund - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_FundDataLoader extends PODataLoader<X_GL_Fund> {
	public static String DATALOADER_GL_Fund_BY_ID = "GL_FundByIdDataLoader";
	public static String DATALOADER_GL_Fund_BY_UUID = "GL_FundByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_Fund.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_Fund_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_Fund_BY_UUID;
	}
}
