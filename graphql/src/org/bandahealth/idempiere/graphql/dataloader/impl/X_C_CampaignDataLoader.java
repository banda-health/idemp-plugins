package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCampaign;

/**
 * Data Loader for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CampaignDataLoader extends PODataLoader<MCampaign> {
	public static String C_Campaign_BY_ID_DATA_LOADER = "C_CampaignByIdDataLoader";
	public static String C_Campaign_BY_UUID_DATA_LOADER = "C_CampaignByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCampaign.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Campaign_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Campaign_BY_UUID_DATA_LOADER;
	}
}
