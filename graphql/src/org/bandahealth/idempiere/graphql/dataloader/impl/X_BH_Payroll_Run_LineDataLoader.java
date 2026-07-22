package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;

/**
 * Data Loader for BH_Payroll_Run_Line - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_LineDataLoader extends PODataLoader<MBHPayrollRunLine> {
	public static String DATALOADER_BH_Payroll_Run_Line_BY_ID = "BH_Payroll_Run_LineByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Run_Line_BY_UUID = "BH_Payroll_Run_LineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollRunLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Run_Line_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Run_Line_BY_UUID;
	}
}
