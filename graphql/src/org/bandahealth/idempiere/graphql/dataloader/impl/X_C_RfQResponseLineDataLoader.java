package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQResponseLine;

/**
 * Data Loader for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQResponseLineDataLoader extends PODataLoader<MRfQResponseLine> {
	public static String DATALOADER_C_RfQResponseLine_BY_ID = "C_RfQResponseLineByIdDataLoader";
	public static String DATALOADER_C_RfQResponseLine_BY_UUID = "C_RfQResponseLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQResponseLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQResponseLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQResponseLine_BY_UUID;
	}
}
