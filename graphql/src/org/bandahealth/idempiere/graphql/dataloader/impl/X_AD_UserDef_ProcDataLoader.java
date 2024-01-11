package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefProc;

/**
 * Data Loader for AD_UserDef_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_ProcDataLoader extends PODataLoader<MUserDefProc> {
	public static String AD_UserDef_Proc_BY_ID_DATA_LOADER = "AD_UserDef_ProcByIdDataLoader";
	public static String AD_UserDef_Proc_BY_UUID_DATA_LOADER = "AD_UserDef_ProcByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefProc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserDef_Proc_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserDef_Proc_BY_UUID_DATA_LOADER;
	}
}
