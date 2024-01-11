package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageLine;

/**
 * Data Loader for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageLineDataLoader extends PODataLoader<MPackageLine> {
	public static String M_PackageLine_BY_ID_DATA_LOADER = "M_PackageLineByIdDataLoader";
	public static String M_PackageLine_BY_UUID_DATA_LOADER = "M_PackageLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PackageLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PackageLine_BY_UUID_DATA_LOADER;
	}
}
