package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSession;

/**
 * Data Loader for AD_Session - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SessionDataLoader extends PODataLoader<MSession> {
	public static String AD_Session_BY_ID_DATA_LOADER = "AD_SessionByIdDataLoader";
	public static String AD_Session_BY_UUID_DATA_LOADER = "AD_SessionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSession.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Session_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Session_BY_UUID_DATA_LOADER;
	}
}
