package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_ReportStatement;

/**
 * Data Loader for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_ReportStatementDataLoader extends PODataLoader<X_T_ReportStatement> {
	public static String DATALOADER_T_ReportStatement_BY_ID = "T_ReportStatementByIdDataLoader";
	public static String DATALOADER_T_ReportStatement_BY_UUID = "T_ReportStatementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_ReportStatement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_ReportStatement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_ReportStatement_BY_UUID;
	}
}
