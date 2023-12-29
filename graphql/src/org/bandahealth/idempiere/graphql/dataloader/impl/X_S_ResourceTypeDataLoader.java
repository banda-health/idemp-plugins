package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResourceType;

/**
 * Data Loader for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceTypeDataLoader extends PODataLoader<MResourceType> {
	public static String S_ResourceType_BY_ID_DATA_LOADER = "S_ResourceTypeByIdDataLoader";
	public static String S_ResourceType_BY_UUID_DATA_LOADER = "S_ResourceTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResourceType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_ResourceType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_ResourceType_BY_UUID_DATA_LOADER;
	}
}
