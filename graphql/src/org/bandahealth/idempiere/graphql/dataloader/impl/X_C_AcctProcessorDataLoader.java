package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctProcessor;

/**
 * Data Loader for C_AcctProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctProcessorDataLoader extends PODataLoader<MAcctProcessor> {
	public static String C_AcctProcessor_BY_ID_DATA_LOADER = "C_AcctProcessorByIdDataLoader";
	public static String C_AcctProcessor_BY_UUID_DATA_LOADER = "C_AcctProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AcctProcessor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AcctProcessor_BY_UUID_DATA_LOADER;
	}
}
