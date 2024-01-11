package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Reconciliation;

/**
 * Data Loader for T_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReconciliationDataLoader extends PODataLoader<X_T_Reconciliation> {
	public static String T_Reconciliation_BY_ID_DATA_LOADER = "T_ReconciliationByIdDataLoader";
	public static String T_Reconciliation_BY_UUID_DATA_LOADER = "T_ReconciliationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Reconciliation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_Reconciliation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_Reconciliation_BY_UUID_DATA_LOADER;
	}
}
