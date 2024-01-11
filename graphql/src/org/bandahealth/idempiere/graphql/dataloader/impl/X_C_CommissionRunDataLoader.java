package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommissionRun;

/**
 * Data Loader for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionRunDataLoader extends PODataLoader<MCommissionRun> {
	public static String C_CommissionRun_BY_ID_DATA_LOADER = "C_CommissionRunByIdDataLoader";
	public static String C_CommissionRun_BY_UUID_DATA_LOADER = "C_CommissionRunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommissionRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CommissionRun_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CommissionRun_BY_UUID_DATA_LOADER;
	}
}
