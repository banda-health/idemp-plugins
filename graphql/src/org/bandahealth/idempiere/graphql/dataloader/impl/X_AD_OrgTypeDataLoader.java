package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_OrgType;

/**
 * Data Loader for AD_OrgType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgTypeDataLoader extends PODataLoader<X_AD_OrgType> {
	public static String AD_OrgType_BY_ID_DATA_LOADER = "AD_OrgTypeByIdDataLoader";
	public static String AD_OrgType_BY_UUID_DATA_LOADER = "AD_OrgTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_OrgType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_OrgType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_OrgType_BY_UUID_DATA_LOADER;
	}
}
