package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageExp;

/**
 * Data Loader for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_ExpDataLoader extends PODataLoader<MPackageExp> {
	public static String AD_Package_Exp_BY_ID_DATA_LOADER = "AD_Package_ExpByIdDataLoader";
	public static String AD_Package_Exp_BY_UUID_DATA_LOADER = "AD_Package_ExpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageExp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Package_Exp_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Package_Exp_BY_UUID_DATA_LOADER;
	}
}
