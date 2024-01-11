package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_Imp;

/**
 * Data Loader for AD_Package_Imp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_ImpDataLoader extends PODataLoader<X_AD_Package_Imp> {
	public static String AD_Package_Imp_BY_ID_DATA_LOADER = "AD_Package_ImpByIdDataLoader";
	public static String AD_Package_Imp_BY_UUID_DATA_LOADER = "AD_Package_ImpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_Imp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Package_Imp_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Package_Imp_BY_UUID_DATA_LOADER;
	}
}
