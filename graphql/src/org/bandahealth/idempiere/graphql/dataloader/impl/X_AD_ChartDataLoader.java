package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChart;

/**
 * Data Loader for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartDataLoader extends PODataLoader<MChart> {
	public static String AD_Chart_BY_ID_DATA_LOADER = "AD_ChartByIdDataLoader";
	public static String AD_Chart_BY_UUID_DATA_LOADER = "AD_ChartByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChart.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Chart_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Chart_BY_UUID_DATA_LOADER;
	}
}
