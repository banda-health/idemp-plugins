package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_InfoRelated;

/**
 * Data Loader for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_InfoRelatedDataLoader extends PODataLoader<X_AD_InfoRelated> {
	public static String DATALOADER_AD_InfoRelated_BY_ID = "AD_InfoRelatedByIdDataLoader";
	public static String DATALOADER_AD_InfoRelated_BY_UUID = "AD_InfoRelatedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_InfoRelated.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_InfoRelated_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_InfoRelated_BY_UUID;
	}
}
