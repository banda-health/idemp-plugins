package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAccount;

/**
 * Data Loader for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ValidCombinationDataLoader extends PODataLoader<MAccount> {
	public static String DATALOADER_C_ValidCombination_BY_ID = "C_ValidCombinationByIdDataLoader";
	public static String DATALOADER_C_ValidCombination_BY_UUID = "C_ValidCombinationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAccount.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ValidCombination_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ValidCombination_BY_UUID;
	}
}
