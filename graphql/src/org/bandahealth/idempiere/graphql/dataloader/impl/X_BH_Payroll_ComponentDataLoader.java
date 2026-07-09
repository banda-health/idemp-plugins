package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollComponent;

/**
 * Data Loader for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_ComponentDataLoader extends PODataLoader<MBHPayrollComponent> {
	public static String DATALOADER_BH_Payroll_Component_BY_ID = "BH_Payroll_ComponentByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Component_BY_UUID = "BH_Payroll_ComponentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollComponent.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Component_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Component_BY_UUID;
	}
}
