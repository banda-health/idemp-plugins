package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLotCtl;

/**
 * Data Loader for M_LotCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotCtlDataLoader extends PODataLoader<MLotCtl> {
	public static String DATALOADER_M_LotCtl_BY_ID = "M_LotCtlByIdDataLoader";
	public static String DATALOADER_M_LotCtl_BY_UUID = "M_LotCtlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLotCtl.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_LotCtl_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_LotCtl_BY_UUID;
	}
}
