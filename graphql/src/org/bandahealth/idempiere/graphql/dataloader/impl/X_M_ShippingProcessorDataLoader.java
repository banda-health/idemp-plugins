package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShippingProcessor;

/**
 * Data Loader for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorDataLoader extends PODataLoader<MShippingProcessor> {
	public static String M_ShippingProcessor_BY_ID_DATA_LOADER = "M_ShippingProcessorByIdDataLoader";
	public static String M_ShippingProcessor_BY_UUID_DATA_LOADER = "M_ShippingProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShippingProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShippingProcessor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShippingProcessor_BY_UUID_DATA_LOADER;
	}
}
