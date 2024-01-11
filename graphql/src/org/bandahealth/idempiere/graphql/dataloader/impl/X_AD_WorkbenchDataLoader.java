package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Workbench;

/**
 * Data Loader for AD_Workbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkbenchDataLoader extends PODataLoader<X_AD_Workbench> {
	public static String AD_Workbench_BY_ID_DATA_LOADER = "AD_WorkbenchByIdDataLoader";
	public static String AD_Workbench_BY_UUID_DATA_LOADER = "AD_WorkbenchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Workbench.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Workbench_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Workbench_BY_UUID_DATA_LOADER;
	}
}
