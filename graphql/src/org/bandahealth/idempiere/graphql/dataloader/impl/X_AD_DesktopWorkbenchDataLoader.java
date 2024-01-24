package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_DesktopWorkbench;

/**
 * Data Loader for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_DesktopWorkbenchDataLoader extends PODataLoader<X_AD_DesktopWorkbench> {
	public static String DATALOADER_AD_DesktopWorkbench_BY_ID = "AD_DesktopWorkbenchByIdDataLoader";
	public static String DATALOADER_AD_DesktopWorkbench_BY_UUID = "AD_DesktopWorkbenchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_DesktopWorkbench.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_DesktopWorkbench_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_DesktopWorkbench_BY_UUID;
	}
}
