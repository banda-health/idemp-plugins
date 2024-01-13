package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShippingProcessor;

/**
 * Data Loader for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorDataLoader extends PODataLoader<MShippingProcessor> {
	public static String DATALOADER_M_ShippingProcessor_BY_ID = "M_ShippingProcessorByIdDataLoader";
	public static String DATALOADER_M_ShippingProcessor_BY_UUID = "M_ShippingProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShippingProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShippingProcessor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShippingProcessor_BY_UUID;
	}
}
