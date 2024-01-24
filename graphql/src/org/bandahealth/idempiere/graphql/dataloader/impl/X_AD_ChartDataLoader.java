package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChart;

/**
 * Data Loader for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartDataLoader extends PODataLoader<MChart> {
	public static String DATALOADER_AD_Chart_BY_ID = "AD_ChartByIdDataLoader";
	public static String DATALOADER_AD_Chart_BY_UUID = "AD_ChartByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChart.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Chart_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Chart_BY_UUID;
	}
}
