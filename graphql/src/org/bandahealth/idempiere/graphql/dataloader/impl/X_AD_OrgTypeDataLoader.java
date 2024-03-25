package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_OrgType;

/**
 * Data Loader for AD_OrgType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgTypeDataLoader extends PODataLoader<X_AD_OrgType> {
	public static String DATALOADER_AD_OrgType_BY_ID = "AD_OrgTypeByIdDataLoader";
	public static String DATALOADER_AD_OrgType_BY_UUID = "AD_OrgTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_OrgType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_OrgType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_OrgType_BY_UUID;
	}
}
