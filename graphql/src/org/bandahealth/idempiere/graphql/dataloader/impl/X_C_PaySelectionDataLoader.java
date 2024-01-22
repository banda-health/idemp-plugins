package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySelection;

/**
 * Data Loader for C_PaySelection - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaySelectionDataLoader extends PODataLoader<MPaySelection> {
	public static String DATALOADER_C_PaySelection_BY_ID = "C_PaySelectionByIdDataLoader";
	public static String DATALOADER_C_PaySelection_BY_UUID = "C_PaySelectionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySelection.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaySelection_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaySelection_BY_UUID;
	}
}
