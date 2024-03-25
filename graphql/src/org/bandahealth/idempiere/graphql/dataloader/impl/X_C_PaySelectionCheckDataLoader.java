package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySelectionCheck;

/**
 * Data Loader for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionCheckDataLoader extends PODataLoader<MPaySelectionCheck> {
	public static String DATALOADER_C_PaySelectionCheck_BY_ID = "C_PaySelectionCheckByIdDataLoader";
	public static String DATALOADER_C_PaySelectionCheck_BY_UUID = "C_PaySelectionCheckByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySelectionCheck.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaySelectionCheck_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaySelectionCheck_BY_UUID;
	}
}
