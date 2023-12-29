package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetGroupAcct;

/**
 * Data Loader for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Group_AcctDataLoader extends PODataLoader<MAssetGroupAcct> {
	public static String A_Asset_Group_Acct_BY_ID_DATA_LOADER = "A_Asset_Group_AcctByIdDataLoader";
	public static String A_Asset_Group_Acct_BY_UUID_DATA_LOADER = "A_Asset_Group_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetGroupAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Group_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Group_Acct_BY_UUID_DATA_LOADER;
	}
}
