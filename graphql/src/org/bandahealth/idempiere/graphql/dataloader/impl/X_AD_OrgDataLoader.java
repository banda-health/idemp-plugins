package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrg;

/**
 * Data Loader for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgDataLoader extends PODataLoader<MOrg> {
	public static String AD_Org_BY_ID_DATA_LOADER = "AD_OrgByIdDataLoader";
	public static String AD_Org_BY_UUID_DATA_LOADER = "AD_OrgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Org_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Org_BY_UUID_DATA_LOADER;
	}
}
