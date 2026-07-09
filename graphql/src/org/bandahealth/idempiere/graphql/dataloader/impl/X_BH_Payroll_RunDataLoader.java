package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollRun;

/**
 * Data Loader for BH_Payroll_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_RunDataLoader extends PODataLoader<MBHPayrollRun> {
	public static String DATALOADER_BH_Payroll_Run_BY_ID = "BH_Payroll_RunByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Run_BY_UUID = "BH_Payroll_RunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Run_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Run_BY_UUID;
	}
}
