package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestAction;

/**
 * Data Loader for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestActionDataLoader extends PODataLoader<MRequestAction> {
	public static String R_RequestAction_BY_ID_DATA_LOADER = "R_RequestActionByIdDataLoader";
	public static String R_RequestAction_BY_UUID_DATA_LOADER = "R_RequestActionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestAction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_RequestAction_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_RequestAction_BY_UUID_DATA_LOADER;
	}
}
