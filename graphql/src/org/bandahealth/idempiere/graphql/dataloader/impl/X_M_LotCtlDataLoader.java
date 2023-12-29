package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLotCtl;

/**
 * Data Loader for M_LotCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotCtlDataLoader extends PODataLoader<MLotCtl> {
	public static String M_LotCtl_BY_ID_DATA_LOADER = "M_LotCtlByIdDataLoader";
	public static String M_LotCtl_BY_UUID_DATA_LOADER = "M_LotCtlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLotCtl.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_LotCtl_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_LotCtl_BY_UUID_DATA_LOADER;
	}
}
