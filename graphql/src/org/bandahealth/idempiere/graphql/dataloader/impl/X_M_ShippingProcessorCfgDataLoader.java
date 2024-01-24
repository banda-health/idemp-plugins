package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShippingProcessorCfg;

/**
 * Data Loader for M_ShippingProcessorCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShippingProcessorCfgDataLoader extends PODataLoader<X_M_ShippingProcessorCfg> {
	public static String DATALOADER_M_ShippingProcessorCfg_BY_ID = "M_ShippingProcessorCfgByIdDataLoader";
	public static String DATALOADER_M_ShippingProcessorCfg_BY_UUID = "M_ShippingProcessorCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShippingProcessorCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShippingProcessorCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShippingProcessorCfg_BY_UUID;
	}
}
