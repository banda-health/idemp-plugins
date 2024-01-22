package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQResponse;

/**
 * Data Loader for C_RfQResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseDataLoader extends PODataLoader<MRfQResponse> {
	public static String DATALOADER_C_RfQResponse_BY_ID = "C_RfQResponseByIdDataLoader";
	public static String DATALOADER_C_RfQResponse_BY_UUID = "C_RfQResponseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQResponse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQResponse_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQResponse_BY_UUID;
	}
}
