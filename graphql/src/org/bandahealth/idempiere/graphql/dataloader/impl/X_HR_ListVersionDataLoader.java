package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_ListVersion;

/**
 * Data Loader for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_ListVersionDataLoader extends PODataLoader<X_HR_ListVersion> {
	public static String DATALOADER_HR_ListVersion_BY_ID = "HR_ListVersionByIdDataLoader";
	public static String DATALOADER_HR_ListVersion_BY_UUID = "HR_ListVersionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_ListVersion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_ListVersion_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_ListVersion_BY_UUID;
	}
}
