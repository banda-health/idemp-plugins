package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefProcParameter;

/**
 * Data Loader for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterDataLoader extends PODataLoader<MUserDefProcParameter> {
	public static String DATALOADER_AD_UserDef_Proc_Parameter_BY_ID = "AD_UserDef_Proc_ParameterByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Proc_Parameter_BY_UUID = "AD_UserDef_Proc_ParameterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefProcParameter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Proc_Parameter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Proc_Parameter_BY_UUID;
	}
}
