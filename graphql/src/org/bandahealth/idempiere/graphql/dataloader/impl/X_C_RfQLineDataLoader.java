package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQLine;

/**
 * Data Loader for C_RfQLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQLineDataLoader extends PODataLoader<MRfQLine> {
	public static String DATALOADER_C_RfQLine_BY_ID = "C_RfQLineByIdDataLoader";
	public static String DATALOADER_C_RfQLine_BY_UUID = "C_RfQLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQLine_BY_UUID;
	}
}
