package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestAction;

/**
 * Data Loader for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestActionDataLoader extends PODataLoader<MRequestAction> {
	public static String DATALOADER_R_RequestAction_BY_ID = "R_RequestActionByIdDataLoader";
	public static String DATALOADER_R_RequestAction_BY_UUID = "R_RequestActionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestAction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_RequestAction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_RequestAction_BY_UUID;
	}
}
