package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_LabelPrinter;

/**
 * Data Loader for AD_LabelPrinter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LabelPrinterDataLoader extends PODataLoader<X_AD_LabelPrinter> {
	public static String DATALOADER_AD_LabelPrinter_BY_ID = "AD_LabelPrinterByIdDataLoader";
	public static String DATALOADER_AD_LabelPrinter_BY_UUID = "AD_LabelPrinterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_LabelPrinter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_LabelPrinter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_LabelPrinter_BY_UUID;
	}
}
