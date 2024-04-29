package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Cost_Collector;

/**
 * Data Loader for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorDataLoader extends PODataLoader<X_PP_Cost_Collector> {
	public static String DATALOADER_PP_Cost_Collector_BY_ID = "PP_Cost_CollectorByIdDataLoader";
	public static String DATALOADER_PP_Cost_Collector_BY_UUID = "PP_Cost_CollectorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Cost_Collector.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Cost_Collector_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Cost_Collector_BY_UUID;
	}
}
