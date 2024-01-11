package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQLine;

/**
 * Data Loader for C_RfQLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQLineDataLoader extends PODataLoader<MRfQLine> {
	public static String C_RfQLine_BY_ID_DATA_LOADER = "C_RfQLineByIdDataLoader";
	public static String C_RfQLine_BY_UUID_DATA_LOADER = "C_RfQLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_RfQLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_RfQLine_BY_UUID_DATA_LOADER;
	}
}
