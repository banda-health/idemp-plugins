package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageMPS;

/**
 * Data Loader for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PackageMPSDataLoader extends PODataLoader<MPackageMPS> {
	public static String DATALOADER_M_PackageMPS_BY_ID = "M_PackageMPSByIdDataLoader";
	public static String DATALOADER_M_PackageMPS_BY_UUID = "M_PackageMPSByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageMPS.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PackageMPS_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PackageMPS_BY_UUID;
	}
}
