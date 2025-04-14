package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_EventAudit;

/**
 * Data Loader for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WF_EventAuditDataLoader extends PODataLoader<X_AD_WF_EventAudit> {
	public static String DATALOADER_AD_WF_EventAudit_BY_ID = "AD_WF_EventAuditByIdDataLoader";
	public static String DATALOADER_AD_WF_EventAudit_BY_UUID = "AD_WF_EventAuditByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_EventAudit.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WF_EventAudit_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WF_EventAudit_BY_UUID;
	}
}
