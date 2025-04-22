package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageLine;

/**
 * Data Loader for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_PackageLineDataLoader extends PODataLoader<MPackageLine> {
	public static String DATALOADER_M_PackageLine_BY_ID = "M_PackageLineByIdDataLoader";
	public static String DATALOADER_M_PackageLine_BY_UUID = "M_PackageLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PackageLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PackageLine_BY_UUID;
	}
}
