package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_Imp_Inst;

/**
 * Data Loader for AD_Package_Imp_Inst - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_InstDataLoader extends PODataLoader<X_AD_Package_Imp_Inst> {
	public static String AD_Package_Imp_Inst_BY_ID_DATA_LOADER = "AD_Package_Imp_InstByIdDataLoader";
	public static String AD_Package_Imp_Inst_BY_UUID_DATA_LOADER = "AD_Package_Imp_InstByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Inst.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Package_Imp_Inst_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Package_Imp_Inst_BY_UUID_DATA_LOADER;
	}
}
