package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAccount;

/**
 * Data Loader for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ValidCombinationDataLoader extends PODataLoader<MAccount> {
	public static String C_ValidCombination_BY_ID_DATA_LOADER = "C_ValidCombinationByIdDataLoader";
	public static String C_ValidCombination_BY_UUID_DATA_LOADER = "C_ValidCombinationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAccount.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ValidCombination_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ValidCombination_BY_UUID_DATA_LOADER;
	}
}
