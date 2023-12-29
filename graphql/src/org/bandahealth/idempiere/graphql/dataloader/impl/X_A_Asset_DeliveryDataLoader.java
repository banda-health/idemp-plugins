package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetDelivery;

/**
 * Data Loader for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DeliveryDataLoader extends PODataLoader<MAssetDelivery> {
	public static String A_Asset_Delivery_BY_ID_DATA_LOADER = "A_Asset_DeliveryByIdDataLoader";
	public static String A_Asset_Delivery_BY_UUID_DATA_LOADER = "A_Asset_DeliveryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetDelivery.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Delivery_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Delivery_BY_UUID_DATA_LOADER;
	}
}
