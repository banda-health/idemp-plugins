package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_Imp_Detail;

/**
 * Data Loader for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_DetailDataLoader extends PODataLoader<X_AD_Package_Imp_Detail> {
	public static String AD_Package_Imp_Detail_BY_ID_DATA_LOADER = "AD_Package_Imp_DetailByIdDataLoader";
	public static String AD_Package_Imp_Detail_BY_UUID_DATA_LOADER = "AD_Package_Imp_DetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Detail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Package_Imp_Detail_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Package_Imp_Detail_BY_UUID_DATA_LOADER;
	}
}
