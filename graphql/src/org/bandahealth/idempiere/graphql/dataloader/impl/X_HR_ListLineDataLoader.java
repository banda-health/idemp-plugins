package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_ListLine;

/**
 * Data Loader for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_ListLineDataLoader extends PODataLoader<X_HR_ListLine> {
	public static String DATALOADER_HR_ListLine_BY_ID = "HR_ListLineByIdDataLoader";
	public static String DATALOADER_HR_ListLine_BY_UUID = "HR_ListLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_ListLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_ListLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_ListLine_BY_UUID;
	}
}
