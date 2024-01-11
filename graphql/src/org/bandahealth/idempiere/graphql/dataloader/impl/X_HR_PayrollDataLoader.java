package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Payroll;

/**
 * Data Loader for HR_Payroll - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_PayrollDataLoader extends PODataLoader<X_HR_Payroll> {
	public static String HR_Payroll_BY_ID_DATA_LOADER = "HR_PayrollByIdDataLoader";
	public static String HR_Payroll_BY_UUID_DATA_LOADER = "HR_PayrollByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Payroll.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Payroll_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Payroll_BY_UUID_DATA_LOADER;
	}
}
