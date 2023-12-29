package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMatchInv;

/**
 * Data Loader for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchInvDataLoader extends PODataLoader<MMatchInv> {
	public static String M_MatchInv_BY_ID_DATA_LOADER = "M_MatchInvByIdDataLoader";
	public static String M_MatchInv_BY_UUID_DATA_LOADER = "M_MatchInvByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMatchInv.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_MatchInv_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_MatchInv_BY_UUID_DATA_LOADER;
	}
}
