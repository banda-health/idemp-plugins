package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetDelivery;

/**
 * Data Loader for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_DeliveryDataLoader extends PODataLoader<MAssetDelivery> {
	public static String DATALOADER_A_Asset_Delivery_BY_ID = "A_Asset_DeliveryByIdDataLoader";
	public static String DATALOADER_A_Asset_Delivery_BY_UUID = "A_Asset_DeliveryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetDelivery.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Delivery_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Delivery_BY_UUID;
	}
}
