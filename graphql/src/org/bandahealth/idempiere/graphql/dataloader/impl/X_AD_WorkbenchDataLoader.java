package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Workbench;

/**
 * Data Loader for AD_Workbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkbenchDataLoader extends PODataLoader<X_AD_Workbench> {
	public static String DATALOADER_AD_Workbench_BY_ID = "AD_WorkbenchByIdDataLoader";
	public static String DATALOADER_AD_Workbench_BY_UUID = "AD_WorkbenchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Workbench.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Workbench_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Workbench_BY_UUID;
	}
}
