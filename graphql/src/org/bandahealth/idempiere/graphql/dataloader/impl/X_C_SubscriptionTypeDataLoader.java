package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_SubscriptionType;

/**
 * Data Loader for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubscriptionTypeDataLoader extends PODataLoader<X_C_SubscriptionType> {
	public static String C_SubscriptionType_BY_ID_DATA_LOADER = "C_SubscriptionTypeByIdDataLoader";
	public static String C_SubscriptionType_BY_UUID_DATA_LOADER = "C_SubscriptionTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_SubscriptionType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_SubscriptionType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_SubscriptionType_BY_UUID_DATA_LOADER;
	}
}
