package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSLACriteria;

/**
 * Data Loader for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_CriteriaDataLoader extends PODataLoader<MSLACriteria> {
	public static String PA_SLA_Criteria_BY_ID_DATA_LOADER = "PA_SLA_CriteriaByIdDataLoader";
	public static String PA_SLA_Criteria_BY_UUID_DATA_LOADER = "PA_SLA_CriteriaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSLACriteria.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_SLA_Criteria_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_SLA_Criteria_BY_UUID_DATA_LOADER;
	}
}
