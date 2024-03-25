package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQ;

/**
 * Data Loader for C_RfQ - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQDataLoader extends PODataLoader<MRfQ> {
	public static String DATALOADER_C_RfQ_BY_ID = "C_RfQByIdDataLoader";
	public static String DATALOADER_C_RfQ_BY_UUID = "C_RfQByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQ.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQ_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQ_BY_UUID;
	}
}
