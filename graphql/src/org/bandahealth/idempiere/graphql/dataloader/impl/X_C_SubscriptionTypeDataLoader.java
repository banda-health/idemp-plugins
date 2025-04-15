package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_SubscriptionType;

/**
 * Data Loader for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_SubscriptionTypeDataLoader extends PODataLoader<X_C_SubscriptionType> {
	public static String DATALOADER_C_SubscriptionType_BY_ID = "C_SubscriptionTypeByIdDataLoader";
	public static String DATALOADER_C_SubscriptionType_BY_UUID = "C_SubscriptionTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_SubscriptionType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_SubscriptionType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_SubscriptionType_BY_UUID;
	}
}
