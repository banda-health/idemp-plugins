package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_Budget;

/**
 * Data Loader for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_BudgetDataLoader extends PODataLoader<X_GL_Budget> {
	public static String DATALOADER_GL_Budget_BY_ID = "GL_BudgetByIdDataLoader";
	public static String DATALOADER_GL_Budget_BY_UUID = "GL_BudgetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_Budget.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_Budget_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_Budget_BY_UUID;
	}
}
