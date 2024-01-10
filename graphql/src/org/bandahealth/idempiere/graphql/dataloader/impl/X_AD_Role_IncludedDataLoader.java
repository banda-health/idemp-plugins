package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRoleIncluded;

/**
 * Data Loader for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Role_IncludedDataLoader extends PODataLoader<MRoleIncluded> {
	public static String AD_Role_Included_BY_ID_DATA_LOADER = "AD_Role_IncludedByIdDataLoader";
	public static String AD_Role_Included_BY_UUID_DATA_LOADER = "AD_Role_IncludedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRoleIncluded.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Role_Included_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Role_Included_BY_UUID_DATA_LOADER;
	}
}
