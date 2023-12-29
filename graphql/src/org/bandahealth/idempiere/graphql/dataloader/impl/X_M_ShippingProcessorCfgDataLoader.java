package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShippingProcessorCfg;

/**
 * Data Loader for M_ShippingProcessorCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorCfgDataLoader extends PODataLoader<X_M_ShippingProcessorCfg> {
	public static String M_ShippingProcessorCfg_BY_ID_DATA_LOADER = "M_ShippingProcessorCfgByIdDataLoader";
	public static String M_ShippingProcessorCfg_BY_UUID_DATA_LOADER = "M_ShippingProcessorCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShippingProcessorCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShippingProcessorCfg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShippingProcessorCfg_BY_UUID_DATA_LOADER;
	}
}
