package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Payroll;

/**
 * Data Loader for HR_Payroll - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_PayrollDataLoader extends PODataLoader<X_HR_Payroll> {
	public static String DATALOADER_HR_Payroll_BY_ID = "HR_PayrollByIdDataLoader";
	public static String DATALOADER_HR_Payroll_BY_UUID = "HR_PayrollByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Payroll.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Payroll_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Payroll_BY_UUID;
	}
}
