package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEntityType;

/**
 * Data Loader for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_EntityTypeDataLoader extends PODataLoader<MEntityType> {
	public static String DATALOADER_AD_EntityType_BY_ID = "AD_EntityTypeByIdDataLoader";
	public static String DATALOADER_AD_EntityType_BY_UUID = "AD_EntityTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEntityType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_EntityType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_EntityType_BY_UUID;
	}
}
