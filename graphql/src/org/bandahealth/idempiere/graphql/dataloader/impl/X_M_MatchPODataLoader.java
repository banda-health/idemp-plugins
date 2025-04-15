package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMatchPO;

/**
 * Data Loader for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MatchPODataLoader extends PODataLoader<MMatchPO> {
	public static String DATALOADER_M_MatchPO_BY_ID = "M_MatchPOByIdDataLoader";
	public static String DATALOADER_M_MatchPO_BY_UUID = "M_MatchPOByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMatchPO.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MatchPO_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MatchPO_BY_UUID;
	}
}
