package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MCurrency_BH;

/**
 * Data Loader for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CurrencyDataLoader extends PODataLoader<MCurrency_BH> {
	public static String DATALOADER_C_Currency_BY_ID = "C_CurrencyByIdDataLoader";
	public static String DATALOADER_C_Currency_BY_UUID = "C_CurrencyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCurrency_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Currency_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Currency_BY_UUID;
	}
}
