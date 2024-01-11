package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintLabel;

/**
 * Data Loader for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintLabelDataLoader extends PODataLoader<X_AD_PrintLabel> {
	public static String AD_PrintLabel_BY_ID_DATA_LOADER = "AD_PrintLabelByIdDataLoader";
	public static String AD_PrintLabel_BY_UUID_DATA_LOADER = "AD_PrintLabelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintLabel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintLabel_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintLabel_BY_UUID_DATA_LOADER;
	}
}
