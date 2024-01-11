package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_ListVersion;

/**
 * Data Loader for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListVersionDataLoader extends PODataLoader<X_HR_ListVersion> {
	public static String HR_ListVersion_BY_ID_DATA_LOADER = "HR_ListVersionByIdDataLoader";
	public static String HR_ListVersion_BY_UUID_DATA_LOADER = "HR_ListVersionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_ListVersion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_ListVersion_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_ListVersion_BY_UUID_DATA_LOADER;
	}
}
