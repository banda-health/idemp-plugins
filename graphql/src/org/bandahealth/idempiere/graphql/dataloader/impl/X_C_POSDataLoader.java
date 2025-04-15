package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOS;

/**
 * Data Loader for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_POSDataLoader extends PODataLoader<MPOS> {
	public static String DATALOADER_C_POS_BY_ID = "C_POSByIdDataLoader";
	public static String DATALOADER_C_POS_BY_UUID = "C_POSByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOS.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_POS_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_POS_BY_UUID;
	}
}
