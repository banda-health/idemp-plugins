package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackage;

/**
 * Data Loader for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PackageDataLoader extends PODataLoader<MPackage> {
	public static String DATALOADER_M_Package_BY_ID = "M_PackageByIdDataLoader";
	public static String DATALOADER_M_Package_BY_UUID = "M_PackageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Package_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Package_BY_UUID;
	}
}
