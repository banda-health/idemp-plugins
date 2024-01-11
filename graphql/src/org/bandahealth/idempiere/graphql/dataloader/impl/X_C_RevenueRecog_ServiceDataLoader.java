package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRevenueRecogService;

/**
 * Data Loader for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecog_ServiceDataLoader extends PODataLoader<MRevenueRecogService> {
	public static String C_RevenueRecog_Service_BY_ID_DATA_LOADER = "C_RevenueRecog_ServiceByIdDataLoader";
	public static String C_RevenueRecog_Service_BY_UUID_DATA_LOADER = "C_RevenueRecog_ServiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRevenueRecogService.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_RevenueRecog_Service_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_RevenueRecog_Service_BY_UUID_DATA_LOADER;
	}
}
