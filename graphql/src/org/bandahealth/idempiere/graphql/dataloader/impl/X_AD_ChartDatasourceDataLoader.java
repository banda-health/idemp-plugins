package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChartDatasource;

/**
 * Data Loader for AD_ChartDatasource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartDatasourceDataLoader extends PODataLoader<MChartDatasource> {
	public static String AD_ChartDatasource_BY_ID_DATA_LOADER = "AD_ChartDatasourceByIdDataLoader";
	public static String AD_ChartDatasource_BY_UUID_DATA_LOADER = "AD_ChartDatasourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChartDatasource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ChartDatasource_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ChartDatasource_BY_UUID_DATA_LOADER;
	}
}
