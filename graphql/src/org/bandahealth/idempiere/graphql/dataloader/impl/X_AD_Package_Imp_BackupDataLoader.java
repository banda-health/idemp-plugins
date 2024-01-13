package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_Imp_Backup;

/**
 * Data Loader for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_BackupDataLoader extends PODataLoader<X_AD_Package_Imp_Backup> {
	public static String DATALOADER_AD_Package_Imp_Backup_BY_ID = "AD_Package_Imp_BackupByIdDataLoader";
	public static String DATALOADER_AD_Package_Imp_Backup_BY_UUID = "AD_Package_Imp_BackupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Backup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Package_Imp_Backup_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Package_Imp_Backup_BY_UUID;
	}
}
