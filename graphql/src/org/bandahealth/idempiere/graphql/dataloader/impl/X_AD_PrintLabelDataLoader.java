package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintLabel;

/**
 * Data Loader for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintLabelDataLoader extends PODataLoader<X_AD_PrintLabel> {
	public static String DATALOADER_AD_PrintLabel_BY_ID = "AD_PrintLabelByIdDataLoader";
	public static String DATALOADER_AD_PrintLabel_BY_UUID = "AD_PrintLabelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintLabel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintLabel_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintLabel_BY_UUID;
	}
}
