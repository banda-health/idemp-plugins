package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDashboardContent;

/**
 * Data Loader for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContentDataLoader extends PODataLoader<MDashboardContent> {
	public static String DATALOADER_PA_DashboardContent_BY_ID = "PA_DashboardContentByIdDataLoader";
	public static String DATALOADER_PA_DashboardContent_BY_UUID = "PA_DashboardContentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDashboardContent.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_DashboardContent_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_DashboardContent_BY_UUID;
	}
}
