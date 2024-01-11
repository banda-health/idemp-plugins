package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySelectionCheck;

/**
 * Data Loader for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaySelectionCheckDataLoader extends PODataLoader<MPaySelectionCheck> {
	public static String C_PaySelectionCheck_BY_ID_DATA_LOADER = "C_PaySelectionCheckByIdDataLoader";
	public static String C_PaySelectionCheck_BY_UUID_DATA_LOADER = "C_PaySelectionCheckByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySelectionCheck.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaySelectionCheck_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaySelectionCheck_BY_UUID_DATA_LOADER;
	}
}
