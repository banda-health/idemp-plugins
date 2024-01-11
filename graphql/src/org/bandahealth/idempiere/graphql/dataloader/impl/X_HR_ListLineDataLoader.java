package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_ListLine;

/**
 * Data Loader for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListLineDataLoader extends PODataLoader<X_HR_ListLine> {
	public static String HR_ListLine_BY_ID_DATA_LOADER = "HR_ListLineByIdDataLoader";
	public static String HR_ListLine_BY_UUID_DATA_LOADER = "HR_ListLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_ListLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_ListLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_ListLine_BY_UUID_DATA_LOADER;
	}
}
