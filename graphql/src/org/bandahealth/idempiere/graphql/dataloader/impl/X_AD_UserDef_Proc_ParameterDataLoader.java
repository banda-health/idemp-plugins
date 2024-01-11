package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefProcParameter;

/**
 * Data Loader for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterDataLoader extends PODataLoader<MUserDefProcParameter> {
	public static String AD_UserDef_Proc_Parameter_BY_ID_DATA_LOADER = "AD_UserDef_Proc_ParameterByIdDataLoader";
	public static String AD_UserDef_Proc_Parameter_BY_UUID_DATA_LOADER = "AD_UserDef_Proc_ParameterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefProcParameter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_UserDef_Proc_Parameter_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_UserDef_Proc_Parameter_BY_UUID_DATA_LOADER;
	}
}
