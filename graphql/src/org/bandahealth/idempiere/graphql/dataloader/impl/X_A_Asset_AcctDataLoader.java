package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetAcct;

/**
 * Data Loader for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_AcctDataLoader extends PODataLoader<MAssetAcct> {
	public static String DATALOADER_A_Asset_Acct_BY_ID = "A_Asset_AcctByIdDataLoader";
	public static String DATALOADER_A_Asset_Acct_BY_UUID = "A_Asset_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Acct_BY_UUID;
	}
}
