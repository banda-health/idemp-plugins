package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTableScriptValidator;

/**
 * Data Loader for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Table_ScriptValidatorDataLoader extends PODataLoader<MTableScriptValidator> {
	public static String DATALOADER_AD_Table_ScriptValidator_BY_ID = "AD_Table_ScriptValidatorByIdDataLoader";
	public static String DATALOADER_AD_Table_ScriptValidator_BY_UUID = "AD_Table_ScriptValidatorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTableScriptValidator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Table_ScriptValidator_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Table_ScriptValidator_BY_UUID;
	}
}
