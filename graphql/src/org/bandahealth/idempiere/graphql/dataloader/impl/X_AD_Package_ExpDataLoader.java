package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPackageExp;

/**
 * Data Loader for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_ExpDataLoader extends PODataLoader<MPackageExp> {
	public static String DATALOADER_AD_Package_Exp_BY_ID = "AD_Package_ExpByIdDataLoader";
	public static String DATALOADER_AD_Package_Exp_BY_UUID = "AD_Package_ExpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPackageExp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Package_Exp_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Package_Exp_BY_UUID;
	}
}
