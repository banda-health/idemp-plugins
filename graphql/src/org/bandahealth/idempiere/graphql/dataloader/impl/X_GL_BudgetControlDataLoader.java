package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_BudgetControl;

/**
 * Data Loader for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_BudgetControlDataLoader extends PODataLoader<X_GL_BudgetControl> {
	public static String GL_BudgetControl_BY_ID_DATA_LOADER = "GL_BudgetControlByIdDataLoader";
	public static String GL_BudgetControl_BY_UUID_DATA_LOADER = "GL_BudgetControlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_BudgetControl.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_BudgetControl_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_BudgetControl_BY_UUID_DATA_LOADER;
	}
}
