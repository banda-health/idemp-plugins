package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMeasureCalc;

/**
 * Data Loader for PA_MeasureCalc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureCalcDataLoader extends PODataLoader<MMeasureCalc> {
	public static String PA_MeasureCalc_BY_ID_DATA_LOADER = "PA_MeasureCalcByIdDataLoader";
	public static String PA_MeasureCalc_BY_UUID_DATA_LOADER = "PA_MeasureCalcByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMeasureCalc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_MeasureCalc_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_MeasureCalc_BY_UUID_DATA_LOADER;
	}
}
