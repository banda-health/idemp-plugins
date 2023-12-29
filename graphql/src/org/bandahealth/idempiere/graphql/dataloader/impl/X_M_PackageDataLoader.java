package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackage;

/**
 * Data Loader for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageDataLoader extends PODataLoader<MPackage> {
	public static String M_Package_BY_ID_DATA_LOADER = "M_PackageByIdDataLoader";
	public static String M_Package_BY_UUID_DATA_LOADER = "M_PackageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Package_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Package_BY_UUID_DATA_LOADER;
	}
}
