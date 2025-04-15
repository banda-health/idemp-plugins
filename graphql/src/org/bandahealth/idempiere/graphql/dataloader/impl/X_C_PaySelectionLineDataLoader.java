package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySelectionLine;

/**
 * Data Loader for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaySelectionLineDataLoader extends PODataLoader<MPaySelectionLine> {
	public static String DATALOADER_C_PaySelectionLine_BY_ID = "C_PaySelectionLineByIdDataLoader";
	public static String DATALOADER_C_PaySelectionLine_BY_UUID = "C_PaySelectionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySelectionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaySelectionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaySelectionLine_BY_UUID;
	}
}
