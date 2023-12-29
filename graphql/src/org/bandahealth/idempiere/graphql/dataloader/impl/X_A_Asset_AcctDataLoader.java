package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetAcct;

/**
 * Data Loader for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_AcctDataLoader extends PODataLoader<MAssetAcct> {
	public static String A_Asset_Acct_BY_ID_DATA_LOADER = "A_Asset_AcctByIdDataLoader";
	public static String A_Asset_Acct_BY_UUID_DATA_LOADER = "A_Asset_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Acct_BY_UUID_DATA_LOADER;
	}
}
