package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBlackListCheque;

/**
 * Data Loader for U_BlackListCheque - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_BlackListChequeDataLoader extends PODataLoader<MBlackListCheque> {
	public static String DATALOADER_U_BlackListCheque_BY_ID = "U_BlackListChequeByIdDataLoader";
	public static String DATALOADER_U_BlackListCheque_BY_UUID = "U_BlackListChequeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBlackListCheque.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_U_BlackListCheque_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_U_BlackListCheque_BY_UUID;
	}
}
