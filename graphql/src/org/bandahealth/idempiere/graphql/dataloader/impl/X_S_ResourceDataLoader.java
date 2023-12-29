package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResource;

/**
 * Data Loader for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceDataLoader extends PODataLoader<MResource> {
	public static String S_Resource_BY_ID_DATA_LOADER = "S_ResourceByIdDataLoader";
	public static String S_Resource_BY_UUID_DATA_LOADER = "S_ResourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_Resource_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_Resource_BY_UUID_DATA_LOADER;
	}
}
