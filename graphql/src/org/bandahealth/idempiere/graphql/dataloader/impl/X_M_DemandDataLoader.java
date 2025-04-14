package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Demand;

/**
 * Data Loader for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DemandDataLoader extends PODataLoader<X_M_Demand> {
	public static String DATALOADER_M_Demand_BY_ID = "M_DemandByIdDataLoader";
	public static String DATALOADER_M_Demand_BY_UUID = "M_DemandByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Demand.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Demand_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Demand_BY_UUID;
	}
}
