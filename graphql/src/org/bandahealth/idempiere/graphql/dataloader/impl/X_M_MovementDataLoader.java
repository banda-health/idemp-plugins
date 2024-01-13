package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMovement_BH;

/**
 * Data Loader for M_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementDataLoader extends PODataLoader<MMovement_BH> {
	public static String DATALOADER_M_Movement_BY_ID = "M_MovementByIdDataLoader";
	public static String DATALOADER_M_Movement_BY_UUID = "M_MovementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovement_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Movement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Movement_BY_UUID;
	}
}
