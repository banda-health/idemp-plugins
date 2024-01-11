package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WizardProcess;

/**
 * Data Loader for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WizardProcessDataLoader extends PODataLoader<X_AD_WizardProcess> {
	public static String AD_WizardProcess_BY_ID_DATA_LOADER = "AD_WizardProcessByIdDataLoader";
	public static String AD_WizardProcess_BY_UUID_DATA_LOADER = "AD_WizardProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WizardProcess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WizardProcess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WizardProcess_BY_UUID_DATA_LOADER;
	}
}
