package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefProc;

/**
 * Data Loader for AD_UserDef_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_ProcDataLoader extends PODataLoader<MUserDefProc> {
	public static String DATALOADER_AD_UserDef_Proc_BY_ID = "AD_UserDef_ProcByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Proc_BY_UUID = "AD_UserDef_ProcByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefProc.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Proc_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Proc_BY_UUID;
	}
}
