package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSLAMeasure;

/**
 * Data Loader for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_MeasureDataLoader extends PODataLoader<MSLAMeasure> {
	public static String DATALOADER_PA_SLA_Measure_BY_ID = "PA_SLA_MeasureByIdDataLoader";
	public static String DATALOADER_PA_SLA_Measure_BY_UUID = "PA_SLA_MeasureByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSLAMeasure.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_SLA_Measure_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_SLA_Measure_BY_UUID;
	}
}
