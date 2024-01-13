package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTimeExpenseLine;

/**
 * Data Loader for S_TimeExpenseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_TimeExpenseLineDataLoader extends PODataLoader<MTimeExpenseLine> {
	public static String DATALOADER_S_TimeExpenseLine_BY_ID = "S_TimeExpenseLineByIdDataLoader";
	public static String DATALOADER_S_TimeExpenseLine_BY_UUID = "S_TimeExpenseLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTimeExpenseLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_TimeExpenseLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_TimeExpenseLine_BY_UUID;
	}
}
