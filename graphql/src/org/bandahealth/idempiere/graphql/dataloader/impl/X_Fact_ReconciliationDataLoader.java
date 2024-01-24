package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFactReconciliation;

/**
 * Data Loader for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_ReconciliationDataLoader extends PODataLoader<MFactReconciliation> {
	public static String DATALOADER_Fact_Reconciliation_BY_ID = "Fact_ReconciliationByIdDataLoader";
	public static String DATALOADER_Fact_Reconciliation_BY_UUID = "Fact_ReconciliationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFactReconciliation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_Fact_Reconciliation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_Fact_Reconciliation_BY_UUID;
	}
}
