package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRoleIncluded;

/**
 * Data Loader for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Role_IncludedDataLoader extends PODataLoader<MRoleIncluded> {
	public static String DATALOADER_AD_Role_Included_BY_ID = "AD_Role_IncludedByIdDataLoader";
	public static String DATALOADER_AD_Role_Included_BY_UUID = "AD_Role_IncludedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRoleIncluded.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Role_Included_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Role_Included_BY_UUID;
	}
}
