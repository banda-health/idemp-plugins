package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_SubAcct;

/**
 * Data Loader for C_SubAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubAcctDataLoader extends PODataLoader<X_C_SubAcct> {
	public static String DATALOADER_C_SubAcct_BY_ID = "C_SubAcctByIdDataLoader";
	public static String DATALOADER_C_SubAcct_BY_UUID = "C_SubAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_SubAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_SubAcct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_SubAcct_BY_UUID;
	}
}
