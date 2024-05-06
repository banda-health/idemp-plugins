package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAcctProcessor;

/**
 * Data Loader for C_AcctProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctProcessorDataLoader extends PODataLoader<MAcctProcessor> {
	public static String DATALOADER_C_AcctProcessor_BY_ID = "C_AcctProcessorByIdDataLoader";
	public static String DATALOADER_C_AcctProcessor_BY_UUID = "C_AcctProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAcctProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AcctProcessor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AcctProcessor_BY_UUID;
	}
}
