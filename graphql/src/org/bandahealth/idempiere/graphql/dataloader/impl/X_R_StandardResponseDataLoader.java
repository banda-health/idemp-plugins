package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_StandardResponse;

/**
 * Data Loader for R_StandardResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StandardResponseDataLoader extends PODataLoader<X_R_StandardResponse> {
	public static String R_StandardResponse_BY_ID_DATA_LOADER = "R_StandardResponseByIdDataLoader";
	public static String R_StandardResponse_BY_UUID_DATA_LOADER = "R_StandardResponseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_StandardResponse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_StandardResponse_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_StandardResponse_BY_UUID_DATA_LOADER;
	}
}
