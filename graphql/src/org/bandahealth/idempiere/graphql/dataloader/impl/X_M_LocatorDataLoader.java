package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLocator;

/**
 * Data Loader for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LocatorDataLoader extends PODataLoader<MLocator> {
	public static String M_Locator_BY_ID_DATA_LOADER = "M_LocatorByIdDataLoader";
	public static String M_Locator_BY_UUID_DATA_LOADER = "M_LocatorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLocator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Locator_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Locator_BY_UUID_DATA_LOADER;
	}
}
