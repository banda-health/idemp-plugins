package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageExpDetail;

/**
 * Data Loader for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Exp_DetailDataLoader extends PODataLoader<MPackageExpDetail> {
	public static String AD_Package_Exp_Detail_BY_ID_DATA_LOADER = "AD_Package_Exp_DetailByIdDataLoader";
	public static String AD_Package_Exp_Detail_BY_UUID_DATA_LOADER = "AD_Package_Exp_DetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageExpDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Package_Exp_Detail_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Package_Exp_Detail_BY_UUID_DATA_LOADER;
	}
}
