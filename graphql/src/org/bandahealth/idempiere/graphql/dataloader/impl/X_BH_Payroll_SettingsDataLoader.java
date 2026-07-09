package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollSettings;

/**
 * Data Loader for BH_Payroll_Settings - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_SettingsDataLoader extends PODataLoader<MBHPayrollSettings> {
	public static String DATALOADER_BH_Payroll_Settings_BY_ID = "BH_Payroll_SettingsByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Settings_BY_UUID = "BH_Payroll_SettingsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollSettings.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Settings_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Settings_BY_UUID;
	}
}
