package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOpportunity;

/**
 * Data Loader for C_Opportunity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OpportunityDataLoader extends PODataLoader<MOpportunity> {
	public static String C_Opportunity_BY_ID_DATA_LOADER = "C_OpportunityByIdDataLoader";
	public static String C_Opportunity_BY_UUID_DATA_LOADER = "C_OpportunityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOpportunity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Opportunity_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Opportunity_BY_UUID_DATA_LOADER;
	}
}
