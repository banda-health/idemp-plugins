package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCash;

/**
 * Data Loader for C_Cash - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashDataLoader extends PODataLoader<MCash> {
	public static String C_Cash_BY_ID_DATA_LOADER = "C_CashByIdDataLoader";
	public static String C_Cash_BY_UUID_DATA_LOADER = "C_CashByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCash.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Cash_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Cash_BY_UUID_DATA_LOADER;
	}
}
