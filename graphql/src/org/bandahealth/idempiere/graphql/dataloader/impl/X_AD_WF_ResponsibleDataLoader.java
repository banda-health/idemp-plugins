package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Responsible;

/**
 * Data Loader for AD_WF_Responsible - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ResponsibleDataLoader extends PODataLoader<X_AD_WF_Responsible> {
	public static String DATALOADER_AD_WF_Responsible_BY_ID = "AD_WF_ResponsibleByIdDataLoader";
	public static String DATALOADER_AD_WF_Responsible_BY_UUID = "AD_WF_ResponsibleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Responsible.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WF_Responsible_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WF_Responsible_BY_UUID;
	}
}
