package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_Imp;

/**
 * Data Loader for AD_Package_Imp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_ImpDataLoader extends PODataLoader<X_AD_Package_Imp> {
	public static String DATALOADER_AD_Package_Imp_BY_ID = "AD_Package_ImpByIdDataLoader";
	public static String DATALOADER_AD_Package_Imp_BY_UUID = "AD_Package_ImpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_Imp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Package_Imp_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Package_Imp_BY_UUID;
	}
}
