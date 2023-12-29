package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;

/**
 * Data Loader for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_SerNoCtlDataLoader extends PODataLoader<MSerNoCtl_BH> {
	public static String M_SerNoCtl_BY_ID_DATA_LOADER = "M_SerNoCtlByIdDataLoader";
	public static String M_SerNoCtl_BY_UUID_DATA_LOADER = "M_SerNoCtlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSerNoCtl_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_SerNoCtl_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_SerNoCtl_BY_UUID_DATA_LOADER;
	}
}
