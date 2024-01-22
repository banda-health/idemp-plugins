package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_GL_BudgetControl;

/**
 * Data Loader for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_BudgetControlDataLoader extends PODataLoader<X_GL_BudgetControl> {
	public static String DATALOADER_GL_BudgetControl_BY_ID = "GL_BudgetControlByIdDataLoader";
	public static String DATALOADER_GL_BudgetControl_BY_UUID = "GL_BudgetControlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_GL_BudgetControl.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_BudgetControl_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_BudgetControl_BY_UUID;
	}
}
