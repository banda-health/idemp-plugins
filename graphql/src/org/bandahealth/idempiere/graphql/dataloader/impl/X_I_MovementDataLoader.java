package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_I_Movement;

/**
 * Data Loader for I_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_MovementDataLoader extends PODataLoader<X_I_Movement> {
	public static String DATALOADER_I_Movement_BY_ID = "I_MovementByIdDataLoader";
	public static String DATALOADER_I_Movement_BY_UUID = "I_MovementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Movement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Movement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Movement_BY_UUID;
	}
}
