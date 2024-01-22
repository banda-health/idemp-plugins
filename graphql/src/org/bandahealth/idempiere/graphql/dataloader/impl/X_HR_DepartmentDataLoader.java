package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Department;

/**
 * Data Loader for HR_Department - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_DepartmentDataLoader extends PODataLoader<X_HR_Department> {
	public static String DATALOADER_HR_Department_BY_ID = "HR_DepartmentByIdDataLoader";
	public static String DATALOADER_HR_Department_BY_UUID = "HR_DepartmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Department.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Department_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Department_BY_UUID;
	}
}
