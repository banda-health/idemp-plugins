package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserMail;

/**
 * Data Loader for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserMailDataLoader extends PODataLoader<MUserMail> {
	public static String DATALOADER_AD_UserMail_BY_ID = "AD_UserMailByIdDataLoader";
	public static String DATALOADER_AD_UserMail_BY_UUID = "AD_UserMailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserMail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserMail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserMail_BY_UUID;
	}
}
