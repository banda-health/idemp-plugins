package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedulerPara;

/**
 * Data Loader for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Scheduler_ParaDataLoader extends PODataLoader<MSchedulerPara> {
	public static String AD_Scheduler_Para_BY_ID_DATA_LOADER = "AD_Scheduler_ParaByIdDataLoader";
	public static String AD_Scheduler_Para_BY_UUID_DATA_LOADER = "AD_Scheduler_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedulerPara.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Scheduler_Para_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Scheduler_Para_BY_UUID_DATA_LOADER;
	}
}
