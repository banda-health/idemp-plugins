package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommission;

/**
 * Data Loader for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionDataLoader extends PODataLoader<MCommission> {
	public static String C_Commission_BY_ID_DATA_LOADER = "C_CommissionByIdDataLoader";
	public static String C_Commission_BY_UUID_DATA_LOADER = "C_CommissionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommission.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Commission_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Commission_BY_UUID_DATA_LOADER;
	}
}
