package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMeasure;

/**
 * Data Loader for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureDataLoader extends PODataLoader<MMeasure> {
	public static String PA_Measure_BY_ID_DATA_LOADER = "PA_MeasureByIdDataLoader";
	public static String PA_Measure_BY_UUID_DATA_LOADER = "PA_MeasureByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMeasure.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Measure_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Measure_BY_UUID_DATA_LOADER;
	}
}
