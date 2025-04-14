package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOpportunity;

/**
 * Data Loader for C_Opportunity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OpportunityDataLoader extends PODataLoader<MOpportunity> {
	public static String DATALOADER_C_Opportunity_BY_ID = "C_OpportunityByIdDataLoader";
	public static String DATALOADER_C_Opportunity_BY_UUID = "C_OpportunityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOpportunity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Opportunity_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Opportunity_BY_UUID;
	}
}
