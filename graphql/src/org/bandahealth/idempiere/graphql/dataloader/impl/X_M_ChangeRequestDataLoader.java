package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChangeRequest;

/**
 * Data Loader for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ChangeRequestDataLoader extends PODataLoader<MChangeRequest> {
	public static String M_ChangeRequest_BY_ID_DATA_LOADER = "M_ChangeRequestByIdDataLoader";
	public static String M_ChangeRequest_BY_UUID_DATA_LOADER = "M_ChangeRequestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChangeRequest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ChangeRequest_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ChangeRequest_BY_UUID_DATA_LOADER;
	}
}
