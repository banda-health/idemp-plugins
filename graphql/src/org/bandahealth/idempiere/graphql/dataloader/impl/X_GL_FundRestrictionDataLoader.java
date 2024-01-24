package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_FundRestriction;

/**
 * Data Loader for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_FundRestrictionDataLoader extends PODataLoader<X_GL_FundRestriction> {
	public static String DATALOADER_GL_FundRestriction_BY_ID = "GL_FundRestrictionByIdDataLoader";
	public static String DATALOADER_GL_FundRestriction_BY_UUID = "GL_FundRestrictionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_FundRestriction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_FundRestriction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_FundRestriction_BY_UUID;
	}
}
