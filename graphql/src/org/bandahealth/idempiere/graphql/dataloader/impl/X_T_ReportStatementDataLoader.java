package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_ReportStatement;

/**
 * Data Loader for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReportStatementDataLoader extends PODataLoader<X_T_ReportStatement> {
	public static String T_ReportStatement_BY_ID_DATA_LOADER = "T_ReportStatementByIdDataLoader";
	public static String T_ReportStatement_BY_UUID_DATA_LOADER = "T_ReportStatementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_ReportStatement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_ReportStatement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_ReportStatement_BY_UUID_DATA_LOADER;
	}
}
