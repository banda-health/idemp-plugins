package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_SubAcct;

/**
 * Data Loader for C_SubAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubAcctDataLoader extends PODataLoader<X_C_SubAcct> {
	public static String C_SubAcct_BY_ID_DATA_LOADER = "C_SubAcctByIdDataLoader";
	public static String C_SubAcct_BY_UUID_DATA_LOADER = "C_SubAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_SubAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_SubAcct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_SubAcct_BY_UUID_DATA_LOADER;
	}
}
