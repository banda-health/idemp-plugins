package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSLACriteria;

/**
 * Data Loader for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_CriteriaDataLoader extends PODataLoader<MSLACriteria> {
	public static String DATALOADER_PA_SLA_Criteria_BY_ID = "PA_SLA_CriteriaByIdDataLoader";
	public static String DATALOADER_PA_SLA_Criteria_BY_UUID = "PA_SLA_CriteriaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSLACriteria.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_SLA_Criteria_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_SLA_Criteria_BY_UUID;
	}
}
