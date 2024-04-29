package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommissionRun;

/**
 * Data Loader for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionRunDataLoader extends PODataLoader<MCommissionRun> {
	public static String DATALOADER_C_CommissionRun_BY_ID = "C_CommissionRunByIdDataLoader";
	public static String DATALOADER_C_CommissionRun_BY_UUID = "C_CommissionRunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommissionRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CommissionRun_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CommissionRun_BY_UUID;
	}
}
