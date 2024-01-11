package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMatchPO;

/**
 * Data Loader for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchPODataLoader extends PODataLoader<MMatchPO> {
	public static String M_MatchPO_BY_ID_DATA_LOADER = "M_MatchPOByIdDataLoader";
	public static String M_MatchPO_BY_UUID_DATA_LOADER = "M_MatchPOByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMatchPO.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_MatchPO_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_MatchPO_BY_UUID_DATA_LOADER;
	}
}
