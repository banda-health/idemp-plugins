package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Employee;

/**
 * Data Loader for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_EmployeeDataLoader extends PODataLoader<X_HR_Employee> {
	public static String HR_Employee_BY_ID_DATA_LOADER = "HR_EmployeeByIdDataLoader";
	public static String HR_Employee_BY_UUID_DATA_LOADER = "HR_EmployeeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Employee.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Employee_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Employee_BY_UUID_DATA_LOADER;
	}
}
