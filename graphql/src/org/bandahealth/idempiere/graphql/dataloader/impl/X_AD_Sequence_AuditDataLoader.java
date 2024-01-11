package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Sequence_Audit;

/**
 * Data Loader for AD_Sequence_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Sequence_AuditDataLoader extends PODataLoader<X_AD_Sequence_Audit> {
	public static String AD_Sequence_Audit_BY_ID_DATA_LOADER = "AD_Sequence_AuditByIdDataLoader";
	public static String AD_Sequence_Audit_BY_UUID_DATA_LOADER = "AD_Sequence_AuditByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Sequence_Audit.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Sequence_Audit_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Sequence_Audit_BY_UUID_DATA_LOADER;
	}
}
