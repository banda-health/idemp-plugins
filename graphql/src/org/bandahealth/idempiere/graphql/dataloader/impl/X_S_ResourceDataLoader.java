package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResource;

/**
 * Data Loader for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_ResourceDataLoader extends PODataLoader<MResource> {
	public static String DATALOADER_S_Resource_BY_ID = "S_ResourceByIdDataLoader";
	public static String DATALOADER_S_Resource_BY_UUID = "S_ResourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_Resource_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_Resource_BY_UUID;
	}
}
