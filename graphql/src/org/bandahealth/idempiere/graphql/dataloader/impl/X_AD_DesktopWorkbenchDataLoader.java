package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_DesktopWorkbench;

/**
 * Data Loader for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_DesktopWorkbenchDataLoader extends PODataLoader<X_AD_DesktopWorkbench> {
	public static String AD_DesktopWorkbench_BY_ID_DATA_LOADER = "AD_DesktopWorkbenchByIdDataLoader";
	public static String AD_DesktopWorkbench_BY_UUID_DATA_LOADER = "AD_DesktopWorkbenchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_DesktopWorkbench.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_DesktopWorkbench_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_DesktopWorkbench_BY_UUID_DATA_LOADER;
	}
}
