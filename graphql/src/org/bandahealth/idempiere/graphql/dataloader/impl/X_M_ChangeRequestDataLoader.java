package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChangeRequest;

/**
 * Data Loader for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ChangeRequestDataLoader extends PODataLoader<MChangeRequest> {
	public static String DATALOADER_M_ChangeRequest_BY_ID = "M_ChangeRequestByIdDataLoader";
	public static String DATALOADER_M_ChangeRequest_BY_UUID = "M_ChangeRequestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChangeRequest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ChangeRequest_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ChangeRequest_BY_UUID;
	}
}
