package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Department;

/**
 * Data Loader for HR_Department - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_DepartmentDataLoader extends PODataLoader<X_HR_Department> {
	public static String HR_Department_BY_ID_DATA_LOADER = "HR_DepartmentByIdDataLoader";
	public static String HR_Department_BY_UUID_DATA_LOADER = "HR_DepartmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Department.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Department_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Department_BY_UUID_DATA_LOADER;
	}
}
