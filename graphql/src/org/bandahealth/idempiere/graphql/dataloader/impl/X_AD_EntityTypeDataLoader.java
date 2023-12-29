package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEntityType;

/**
 * Data Loader for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_EntityTypeDataLoader extends PODataLoader<MEntityType> {
	public static String AD_EntityType_BY_ID_DATA_LOADER = "AD_EntityTypeByIdDataLoader";
	public static String AD_EntityType_BY_UUID_DATA_LOADER = "AD_EntityTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEntityType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_EntityType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_EntityType_BY_UUID_DATA_LOADER;
	}
}
