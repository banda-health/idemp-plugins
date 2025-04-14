package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommission;

/**
 * Data Loader for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionDataLoader extends PODataLoader<MCommission> {
	public static String DATALOADER_C_Commission_BY_ID = "C_CommissionByIdDataLoader";
	public static String DATALOADER_C_Commission_BY_UUID = "C_CommissionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommission.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Commission_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Commission_BY_UUID;
	}
}
