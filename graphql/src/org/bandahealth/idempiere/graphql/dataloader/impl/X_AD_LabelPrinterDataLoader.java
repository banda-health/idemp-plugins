package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_LabelPrinter;

/**
 * Data Loader for AD_LabelPrinter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LabelPrinterDataLoader extends PODataLoader<X_AD_LabelPrinter> {
	public static String AD_LabelPrinter_BY_ID_DATA_LOADER = "AD_LabelPrinterByIdDataLoader";
	public static String AD_LabelPrinter_BY_UUID_DATA_LOADER = "AD_LabelPrinterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_LabelPrinter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_LabelPrinter_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_LabelPrinter_BY_UUID_DATA_LOADER;
	}
}
