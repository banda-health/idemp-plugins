package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollFiling;

/**
 * Data Loader for BH_Payroll_Filing - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_FilingDataLoader extends PODataLoader<MBHPayrollFiling> {
	public static String DATALOADER_BH_Payroll_Filing_BY_ID = "BH_Payroll_FilingByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Filing_BY_UUID = "BH_Payroll_FilingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollFiling.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Filing_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Filing_BY_UUID;
	}
}
