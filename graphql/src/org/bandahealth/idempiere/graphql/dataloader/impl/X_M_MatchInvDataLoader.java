package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMatchInv;

/**
 * Data Loader for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MatchInvDataLoader extends PODataLoader<MMatchInv> {
	public static String DATALOADER_M_MatchInv_BY_ID = "M_MatchInvByIdDataLoader";
	public static String DATALOADER_M_MatchInv_BY_UUID = "M_MatchInvByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMatchInv.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MatchInv_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MatchInv_BY_UUID;
	}
}
