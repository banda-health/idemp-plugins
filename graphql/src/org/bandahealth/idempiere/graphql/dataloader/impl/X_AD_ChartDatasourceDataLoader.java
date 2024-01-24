package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChartDatasource;

/**
 * Data Loader for AD_ChartDatasource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartDatasourceDataLoader extends PODataLoader<MChartDatasource> {
	public static String DATALOADER_AD_ChartDatasource_BY_ID = "AD_ChartDatasourceByIdDataLoader";
	public static String DATALOADER_AD_ChartDatasource_BY_UUID = "AD_ChartDatasourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChartDatasource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ChartDatasource_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ChartDatasource_BY_UUID;
	}
}
