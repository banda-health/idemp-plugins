package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Subscription_Delivery;

/**
 * Data Loader for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_Subscription_DeliveryDataLoader extends PODataLoader<X_C_Subscription_Delivery> {
	public static String DATALOADER_C_Subscription_Delivery_BY_ID = "C_Subscription_DeliveryByIdDataLoader";
	public static String DATALOADER_C_Subscription_Delivery_BY_UUID = "C_Subscription_DeliveryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Subscription_Delivery.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Subscription_Delivery_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Subscription_Delivery_BY_UUID;
	}
}
