package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Reconciliation;

/**
 * Data Loader for T_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReconciliationDataLoader extends PODataLoader<X_T_Reconciliation> {
	public static String DATALOADER_T_Reconciliation_BY_ID = "T_ReconciliationByIdDataLoader";
	public static String DATALOADER_T_Reconciliation_BY_UUID = "T_ReconciliationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Reconciliation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_Reconciliation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_Reconciliation_BY_UUID;
	}
}
