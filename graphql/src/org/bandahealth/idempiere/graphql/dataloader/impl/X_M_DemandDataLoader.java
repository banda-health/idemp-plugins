package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Demand;

/**
 * Data Loader for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandDataLoader extends PODataLoader<X_M_Demand> {
	public static String M_Demand_BY_ID_DATA_LOADER = "M_DemandByIdDataLoader";
	public static String M_Demand_BY_UUID_DATA_LOADER = "M_DemandByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Demand.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Demand_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Demand_BY_UUID_DATA_LOADER;
	}
}
