package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_EventAudit;

/**
 * Data Loader for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_EventAuditDataLoader extends PODataLoader<X_AD_WF_EventAudit> {
	public static String AD_WF_EventAudit_BY_ID_DATA_LOADER = "AD_WF_EventAuditByIdDataLoader";
	public static String AD_WF_EventAudit_BY_UUID_DATA_LOADER = "AD_WF_EventAuditByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_EventAudit.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_EventAudit_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_EventAudit_BY_UUID_DATA_LOADER;
	}
}
