package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Activity;

/**
 * Data Loader for AD_WF_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WF_ActivityDataLoader extends PODataLoader<X_AD_WF_Activity> {
	public static String DATALOADER_AD_WF_Activity_BY_ID = "AD_WF_ActivityByIdDataLoader";
	public static String DATALOADER_AD_WF_Activity_BY_UUID = "AD_WF_ActivityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Activity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WF_Activity_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WF_Activity_BY_UUID;
	}
}
