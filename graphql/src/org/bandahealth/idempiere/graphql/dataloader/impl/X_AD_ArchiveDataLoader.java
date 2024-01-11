package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MArchive;

/**
 * Data Loader for AD_Archive - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ArchiveDataLoader extends PODataLoader<MArchive> {
	public static String AD_Archive_BY_ID_DATA_LOADER = "AD_ArchiveByIdDataLoader";
	public static String AD_Archive_BY_UUID_DATA_LOADER = "AD_ArchiveByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MArchive.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Archive_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Archive_BY_UUID_DATA_LOADER;
	}
}
