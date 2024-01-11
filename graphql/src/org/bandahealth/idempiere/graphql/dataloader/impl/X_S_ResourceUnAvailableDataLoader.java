package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResourceUnAvailable;

/**
 * Data Loader for S_ResourceUnAvailable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceUnAvailableDataLoader extends PODataLoader<MResourceUnAvailable> {
	public static String S_ResourceUnAvailable_BY_ID_DATA_LOADER = "S_ResourceUnAvailableByIdDataLoader";
	public static String S_ResourceUnAvailable_BY_UUID_DATA_LOADER = "S_ResourceUnAvailableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResourceUnAvailable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_ResourceUnAvailable_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_ResourceUnAvailable_BY_UUID_DATA_LOADER;
	}
}
