package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_InfoRelated;

/**
 * Data Loader for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_InfoRelatedDataLoader extends PODataLoader<X_AD_InfoRelated> {
	public static String AD_InfoRelated_BY_ID_DATA_LOADER = "AD_InfoRelatedByIdDataLoader";
	public static String AD_InfoRelated_BY_UUID_DATA_LOADER = "AD_InfoRelatedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_InfoRelated.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_InfoRelated_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_InfoRelated_BY_UUID_DATA_LOADER;
	}
}
