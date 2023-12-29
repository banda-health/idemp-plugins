package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Cost_Collector;

/**
 * Data Loader for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Cost_CollectorDataLoader extends PODataLoader<X_PP_Cost_Collector> {
	public static String PP_Cost_Collector_BY_ID_DATA_LOADER = "PP_Cost_CollectorByIdDataLoader";
	public static String PP_Cost_Collector_BY_UUID_DATA_LOADER = "PP_Cost_CollectorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Cost_Collector.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Cost_Collector_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Cost_Collector_BY_UUID_DATA_LOADER;
	}
}
