package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Package_Imp_Proc;

/**
 * Data Loader for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_Imp_ProcDataLoader extends PODataLoader<X_AD_Package_Imp_Proc> {
	public static String DATALOADER_AD_Package_Imp_Proc_BY_ID = "AD_Package_Imp_ProcByIdDataLoader";
	public static String DATALOADER_AD_Package_Imp_Proc_BY_UUID = "AD_Package_Imp_ProcByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Proc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Package_Imp_Proc_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Package_Imp_Proc_BY_UUID;
	}
}
