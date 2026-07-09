package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;

/**
 * Data Loader for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_Line_ItemDataLoader extends PODataLoader<MBHPayrollRunLineItem> {
	public static String DATALOADER_BH_Payroll_Run_Line_Item_BY_ID = "BH_Payroll_Run_Line_ItemByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Run_Line_Item_BY_UUID = "BH_Payroll_Run_Line_ItemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollRunLineItem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Run_Line_Item_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Run_Line_Item_BY_UUID;
	}
}
