package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MHREmployee_BH;

/**
 * Data Loader for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_EmployeeDataLoader extends PODataLoader<MHREmployee_BH> {
	public static String DATALOADER_HR_Employee_BY_ID = "HR_EmployeeByIdDataLoader";
	public static String DATALOADER_HR_Employee_BY_UUID = "HR_EmployeeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MHREmployee_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Employee_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Employee_BY_UUID;
	}
}
