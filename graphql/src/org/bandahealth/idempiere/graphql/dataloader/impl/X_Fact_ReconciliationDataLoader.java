package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFactReconciliation;

/**
 * Data Loader for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_ReconciliationDataLoader extends PODataLoader<MFactReconciliation> {
	public static String Fact_Reconciliation_BY_ID_DATA_LOADER = "Fact_ReconciliationByIdDataLoader";
	public static String Fact_Reconciliation_BY_UUID_DATA_LOADER = "Fact_ReconciliationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFactReconciliation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return Fact_Reconciliation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return Fact_Reconciliation_BY_UUID_DATA_LOADER;
	}
}
