package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBlackListCheque;

/**
 * Data Loader for U_BlackListCheque - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_BlackListChequeDataLoader extends PODataLoader<MBlackListCheque> {
	public static String U_BlackListCheque_BY_ID_DATA_LOADER = "U_BlackListChequeByIdDataLoader";
	public static String U_BlackListCheque_BY_UUID_DATA_LOADER = "U_BlackListChequeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBlackListCheque.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return U_BlackListCheque_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return U_BlackListCheque_BY_UUID_DATA_LOADER;
	}
}
