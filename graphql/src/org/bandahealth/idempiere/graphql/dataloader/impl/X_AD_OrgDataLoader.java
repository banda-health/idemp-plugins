package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrg;

/**
 * Data Loader for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_OrgDataLoader extends PODataLoader<MOrg> {
	public static String DATALOADER_AD_Org_BY_ID = "AD_OrgByIdDataLoader";
	public static String DATALOADER_AD_Org_BY_UUID = "AD_OrgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Org_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Org_BY_UUID;
	}
}
