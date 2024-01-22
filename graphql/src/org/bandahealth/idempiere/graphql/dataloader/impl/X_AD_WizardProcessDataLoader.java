package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WizardProcess;

/**
 * Data Loader for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WizardProcessDataLoader extends PODataLoader<X_AD_WizardProcess> {
	public static String DATALOADER_AD_WizardProcess_BY_ID = "AD_WizardProcessByIdDataLoader";
	public static String DATALOADER_AD_WizardProcess_BY_UUID = "AD_WizardProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WizardProcess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WizardProcess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WizardProcess_BY_UUID;
	}
}
