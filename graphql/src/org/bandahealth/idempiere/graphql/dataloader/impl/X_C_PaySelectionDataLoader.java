package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySelection;

/**
 * Data Loader for C_PaySelection - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaySelectionDataLoader extends PODataLoader<MPaySelection> {
	public static String C_PaySelection_BY_ID_DATA_LOADER = "C_PaySelectionByIdDataLoader";
	public static String C_PaySelection_BY_UUID_DATA_LOADER = "C_PaySelectionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySelection.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaySelection_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaySelection_BY_UUID_DATA_LOADER;
	}
}
