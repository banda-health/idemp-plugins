package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserMail;

/**
 * Data Loader for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserMailDataLoader extends PODataLoader<MUserMail> {
	public static String AD_UserMail_BY_ID_DATA_LOADER = "AD_UserMailByIdDataLoader";
	public static String AD_UserMail_BY_UUID_DATA_LOADER = "AD_UserMailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserMail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserMail_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserMail_BY_UUID_DATA_LOADER;
	}
}
