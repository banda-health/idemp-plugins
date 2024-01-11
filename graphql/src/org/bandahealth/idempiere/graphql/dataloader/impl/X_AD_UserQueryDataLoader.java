package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserQuery;

/**
 * Data Loader for AD_UserQuery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserQueryDataLoader extends PODataLoader<MUserQuery> {
	public static String AD_UserQuery_BY_ID_DATA_LOADER = "AD_UserQueryByIdDataLoader";
	public static String AD_UserQuery_BY_UUID_DATA_LOADER = "AD_UserQueryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserQuery.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserQuery_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserQuery_BY_UUID_DATA_LOADER;
	}
}
