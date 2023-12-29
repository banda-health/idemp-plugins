package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_Budget;

/**
 * Data Loader for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_BudgetDataLoader extends PODataLoader<X_GL_Budget> {
	public static String GL_Budget_BY_ID_DATA_LOADER = "GL_BudgetByIdDataLoader";
	public static String GL_Budget_BY_UUID_DATA_LOADER = "GL_BudgetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_Budget.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_Budget_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_Budget_BY_UUID_DATA_LOADER;
	}
}
