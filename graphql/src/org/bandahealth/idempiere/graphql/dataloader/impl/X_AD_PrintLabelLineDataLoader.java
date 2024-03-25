package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintLabelLine;

/**
 * Data Loader for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintLabelLineDataLoader extends PODataLoader<X_AD_PrintLabelLine> {
	public static String DATALOADER_AD_PrintLabelLine_BY_ID = "AD_PrintLabelLineByIdDataLoader";
	public static String DATALOADER_AD_PrintLabelLine_BY_UUID = "AD_PrintLabelLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintLabelLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintLabelLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintLabelLine_BY_UUID;
	}
}
