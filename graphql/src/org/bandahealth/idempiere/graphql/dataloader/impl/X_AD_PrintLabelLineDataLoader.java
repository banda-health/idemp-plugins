package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintLabelLine;

/**
 * Data Loader for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintLabelLineDataLoader extends PODataLoader<X_AD_PrintLabelLine> {
	public static String AD_PrintLabelLine_BY_ID_DATA_LOADER = "AD_PrintLabelLineByIdDataLoader";
	public static String AD_PrintLabelLine_BY_UUID_DATA_LOADER = "AD_PrintLabelLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintLabelLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintLabelLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintLabelLine_BY_UUID_DATA_LOADER;
	}
}
