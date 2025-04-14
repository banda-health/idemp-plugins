package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_StandardResponse;

/**
 * Data Loader for R_StandardResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_StandardResponseDataLoader extends PODataLoader<X_R_StandardResponse> {
	public static String DATALOADER_R_StandardResponse_BY_ID = "R_StandardResponseByIdDataLoader";
	public static String DATALOADER_R_StandardResponse_BY_UUID = "R_StandardResponseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_StandardResponse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_StandardResponse_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_StandardResponse_BY_UUID;
	}
}
