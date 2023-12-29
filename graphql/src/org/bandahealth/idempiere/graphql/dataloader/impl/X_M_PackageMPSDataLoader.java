package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageMPS;

/**
 * Data Loader for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageMPSDataLoader extends PODataLoader<MPackageMPS> {
	public static String M_PackageMPS_BY_ID_DATA_LOADER = "M_PackageMPSByIdDataLoader";
	public static String M_PackageMPS_BY_UUID_DATA_LOADER = "M_PackageMPSByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageMPS.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PackageMPS_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PackageMPS_BY_UUID_DATA_LOADER;
	}
}
