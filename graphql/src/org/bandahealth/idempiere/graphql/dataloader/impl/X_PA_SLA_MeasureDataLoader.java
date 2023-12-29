package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSLAMeasure;

/**
 * Data Loader for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_MeasureDataLoader extends PODataLoader<MSLAMeasure> {
	public static String PA_SLA_Measure_BY_ID_DATA_LOADER = "PA_SLA_MeasureByIdDataLoader";
	public static String PA_SLA_Measure_BY_UUID_DATA_LOADER = "PA_SLA_MeasureByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSLAMeasure.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_SLA_Measure_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_SLA_Measure_BY_UUID_DATA_LOADER;
	}
}
