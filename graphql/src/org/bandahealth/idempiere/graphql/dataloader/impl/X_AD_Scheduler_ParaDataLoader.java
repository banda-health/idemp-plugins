package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedulerPara;

/**
 * Data Loader for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Scheduler_ParaDataLoader extends PODataLoader<MSchedulerPara> {
	public static String DATALOADER_AD_Scheduler_Para_BY_ID = "AD_Scheduler_ParaByIdDataLoader";
	public static String DATALOADER_AD_Scheduler_Para_BY_UUID = "AD_Scheduler_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedulerPara.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Scheduler_Para_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Scheduler_Para_BY_UUID;
	}
}
