package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRevenueRecogService;

/**
 * Data Loader for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecog_ServiceDataLoader extends PODataLoader<MRevenueRecogService> {
	public static String DATALOADER_C_RevenueRecog_Service_BY_ID = "C_RevenueRecog_ServiceByIdDataLoader";
	public static String DATALOADER_C_RevenueRecog_Service_BY_UUID = "C_RevenueRecog_ServiceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRevenueRecogService.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RevenueRecog_Service_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RevenueRecog_Service_BY_UUID;
	}
}
