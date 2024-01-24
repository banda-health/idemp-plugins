package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSession;

/**
 * Data Loader for AD_Session - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SessionDataLoader extends PODataLoader<MSession> {
	public static String DATALOADER_AD_Session_BY_ID = "AD_SessionByIdDataLoader";
	public static String DATALOADER_AD_Session_BY_UUID = "AD_SessionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSession.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Session_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Session_BY_UUID;
	}
}
