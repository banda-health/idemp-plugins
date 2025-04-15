package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MArchive;

/**
 * Data Loader for AD_Archive - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ArchiveDataLoader extends PODataLoader<MArchive> {
	public static String DATALOADER_AD_Archive_BY_ID = "AD_ArchiveByIdDataLoader";
	public static String DATALOADER_AD_Archive_BY_UUID = "AD_ArchiveByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MArchive.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Archive_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Archive_BY_UUID;
	}
}
