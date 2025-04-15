package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetGroupAcct;

/**
 * Data Loader for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_Group_AcctDataLoader extends PODataLoader<MAssetGroupAcct> {
	public static String DATALOADER_A_Asset_Group_Acct_BY_ID = "A_Asset_Group_AcctByIdDataLoader";
	public static String DATALOADER_A_Asset_Group_Acct_BY_UUID = "A_Asset_Group_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetGroupAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Group_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Group_Acct_BY_UUID;
	}
}
