package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_RelationType;

/**
 * Data Loader for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RelationTypeDataLoader extends PODataLoader<X_AD_RelationType> {
	public static String DATALOADER_AD_RelationType_BY_ID = "AD_RelationTypeByIdDataLoader";
	public static String DATALOADER_AD_RelationType_BY_UUID = "AD_RelationTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_RelationType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_RelationType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_RelationType_BY_UUID;
	}
}
