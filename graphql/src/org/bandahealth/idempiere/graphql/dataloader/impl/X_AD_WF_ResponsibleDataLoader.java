package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Responsible;

/**
 * Data Loader for AD_WF_Responsible - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ResponsibleDataLoader extends PODataLoader<X_AD_WF_Responsible> {
	public static String AD_WF_Responsible_BY_ID_DATA_LOADER = "AD_WF_ResponsibleByIdDataLoader";
	public static String AD_WF_Responsible_BY_UUID_DATA_LOADER = "AD_WF_ResponsibleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Responsible.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_Responsible_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_Responsible_BY_UUID_DATA_LOADER;
	}
}
