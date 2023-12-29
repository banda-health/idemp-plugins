package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOSKeyLayout;

/**
 * Data Loader for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyLayoutDataLoader extends PODataLoader<MPOSKeyLayout> {
	public static String C_POSKeyLayout_BY_ID_DATA_LOADER = "C_POSKeyLayoutByIdDataLoader";
	public static String C_POSKeyLayout_BY_UUID_DATA_LOADER = "C_POSKeyLayoutByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOSKeyLayout.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_POSKeyLayout_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_POSKeyLayout_BY_UUID_DATA_LOADER;
	}
}
