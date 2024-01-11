package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_I_Movement;

/**
 * Data Loader for I_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_MovementDataLoader extends PODataLoader<X_I_Movement> {
	public static String I_Movement_BY_ID_DATA_LOADER = "I_MovementByIdDataLoader";
	public static String I_Movement_BY_UUID_DATA_LOADER = "I_MovementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Movement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Movement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Movement_BY_UUID_DATA_LOADER;
	}
}
