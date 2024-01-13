package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMeasure;

/**
 * Data Loader for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureDataLoader extends PODataLoader<MMeasure> {
	public static String DATALOADER_PA_Measure_BY_ID = "PA_MeasureByIdDataLoader";
	public static String DATALOADER_PA_Measure_BY_UUID = "PA_MeasureByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMeasure.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Measure_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Measure_BY_UUID;
	}
}
