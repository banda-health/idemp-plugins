package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTableScriptValidator;

/**
 * Data Loader for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Table_ScriptValidatorDataLoader extends PODataLoader<MTableScriptValidator> {
	public static String AD_Table_ScriptValidator_BY_ID_DATA_LOADER = "AD_Table_ScriptValidatorByIdDataLoader";
	public static String AD_Table_ScriptValidator_BY_UUID_DATA_LOADER = "AD_Table_ScriptValidatorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTableScriptValidator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Table_ScriptValidator_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Table_ScriptValidator_BY_UUID_DATA_LOADER;
	}
}
