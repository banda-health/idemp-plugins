package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCurrency;

/**
 * Data Loader for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CurrencyDataLoader extends PODataLoader<MCurrency> {
	public static String C_Currency_BY_ID_DATA_LOADER = "C_CurrencyByIdDataLoader";
	public static String C_Currency_BY_UUID_DATA_LOADER = "C_CurrencyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCurrency.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Currency_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Currency_BY_UUID_DATA_LOADER;
	}
}
