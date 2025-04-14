package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_User_Substitute;

/**
 * Data Loader for AD_User_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_User_SubstituteDataLoader extends PODataLoader<X_AD_User_Substitute> {
	public static String DATALOADER_AD_User_Substitute_BY_ID = "AD_User_SubstituteByIdDataLoader";
	public static String DATALOADER_AD_User_Substitute_BY_UUID = "AD_User_SubstituteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_User_Substitute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_User_Substitute_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_User_Substitute_BY_UUID;
	}
}
