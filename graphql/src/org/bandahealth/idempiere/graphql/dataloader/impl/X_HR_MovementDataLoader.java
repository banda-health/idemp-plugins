package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Movement;

/**
 * Data Loader for HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_MovementDataLoader extends PODataLoader<X_HR_Movement> {
	public static String DATALOADER_HR_Movement_BY_ID = "HR_MovementByIdDataLoader";
	public static String DATALOADER_HR_Movement_BY_UUID = "HR_MovementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Movement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Movement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Movement_BY_UUID;
	}
}
