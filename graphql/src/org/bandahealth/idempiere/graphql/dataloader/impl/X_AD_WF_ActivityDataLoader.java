package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Activity;

/**
 * Data Loader for AD_WF_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityDataLoader extends PODataLoader<X_AD_WF_Activity> {
	public static String AD_WF_Activity_BY_ID_DATA_LOADER = "AD_WF_ActivityByIdDataLoader";
	public static String AD_WF_Activity_BY_UUID_DATA_LOADER = "AD_WF_ActivityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Activity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_Activity_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_Activity_BY_UUID_DATA_LOADER;
	}
}
