package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserQuery;

/**
 * Data Loader for AD_UserQuery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserQueryDataLoader extends PODataLoader<MUserQuery> {
	public static String DATALOADER_AD_UserQuery_BY_ID = "AD_UserQueryByIdDataLoader";
	public static String DATALOADER_AD_UserQuery_BY_UUID = "AD_UserQueryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserQuery.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserQuery_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserQuery_BY_UUID;
	}
}
