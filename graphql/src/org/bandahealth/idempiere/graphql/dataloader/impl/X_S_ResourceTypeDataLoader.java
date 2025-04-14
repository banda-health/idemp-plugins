package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResourceType;

/**
 * Data Loader for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceTypeDataLoader extends PODataLoader<MResourceType> {
	public static String DATALOADER_S_ResourceType_BY_ID = "S_ResourceTypeByIdDataLoader";
	public static String DATALOADER_S_ResourceType_BY_UUID = "S_ResourceTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResourceType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_ResourceType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_ResourceType_BY_UUID;
	}
}
