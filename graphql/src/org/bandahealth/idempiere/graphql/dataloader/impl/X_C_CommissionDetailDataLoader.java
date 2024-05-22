package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCommissionDetail;

/**
 * Data Loader for C_CommissionDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionDetailDataLoader extends PODataLoader<MCommissionDetail> {
	public static String DATALOADER_C_CommissionDetail_BY_ID = "C_CommissionDetailByIdDataLoader";
	public static String DATALOADER_C_CommissionDetail_BY_UUID = "C_CommissionDetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCommissionDetail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CommissionDetail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CommissionDetail_BY_UUID;
	}
}
