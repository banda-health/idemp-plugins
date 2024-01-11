package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_RelationType;

/**
 * Data Loader for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RelationTypeDataLoader extends PODataLoader<X_AD_RelationType> {
	public static String AD_RelationType_BY_ID_DATA_LOADER = "AD_RelationTypeByIdDataLoader";
	public static String AD_RelationType_BY_UUID_DATA_LOADER = "AD_RelationTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_RelationType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_RelationType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_RelationType_BY_UUID_DATA_LOADER;
	}
}
