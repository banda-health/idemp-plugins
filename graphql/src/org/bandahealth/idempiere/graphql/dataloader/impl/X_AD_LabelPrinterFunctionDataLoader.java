package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_LabelPrinterFunction;

/**
 * Data Loader for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_LabelPrinterFunctionDataLoader extends PODataLoader<X_AD_LabelPrinterFunction> {
	public static String DATALOADER_AD_LabelPrinterFunction_BY_ID = "AD_LabelPrinterFunctionByIdDataLoader";
	public static String DATALOADER_AD_LabelPrinterFunction_BY_UUID = "AD_LabelPrinterFunctionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_LabelPrinterFunction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_LabelPrinterFunction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_LabelPrinterFunction_BY_UUID;
	}
}
