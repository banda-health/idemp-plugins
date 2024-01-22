package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMeasureCalc;

/**
 * Data Loader for PA_MeasureCalc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_MeasureCalcDataLoader extends PODataLoader<MMeasureCalc> {
	public static String DATALOADER_PA_MeasureCalc_BY_ID = "PA_MeasureCalcByIdDataLoader";
	public static String DATALOADER_PA_MeasureCalc_BY_UUID = "PA_MeasureCalcByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMeasureCalc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_MeasureCalc_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_MeasureCalc_BY_UUID;
	}
}
