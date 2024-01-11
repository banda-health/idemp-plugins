package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Subscription;

/**
 * Data Loader for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubscriptionDataLoader extends PODataLoader<X_C_Subscription> {
	public static String C_Subscription_BY_ID_DATA_LOADER = "C_SubscriptionByIdDataLoader";
	public static String C_Subscription_BY_UUID_DATA_LOADER = "C_SubscriptionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Subscription.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Subscription_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Subscription_BY_UUID_DATA_LOADER;
	}
}
