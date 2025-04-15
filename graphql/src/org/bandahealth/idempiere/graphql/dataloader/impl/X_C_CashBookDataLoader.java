package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashBook;

/**
 * Data Loader for C_CashBook - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CashBookDataLoader extends PODataLoader<MCashBook> {
	public static String DATALOADER_C_CashBook_BY_ID = "C_CashBookByIdDataLoader";
	public static String DATALOADER_C_CashBook_BY_UUID = "C_CashBookByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashBook.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CashBook_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CashBook_BY_UUID;
	}
}
