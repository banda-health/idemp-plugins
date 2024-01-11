package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Movement;

/**
 * Data Loader for HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_MovementDataLoader extends PODataLoader<X_HR_Movement> {
	public static String HR_Movement_BY_ID_DATA_LOADER = "HR_MovementByIdDataLoader";
	public static String HR_Movement_BY_UUID_DATA_LOADER = "HR_MovementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Movement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Movement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Movement_BY_UUID_DATA_LOADER;
	}
}
