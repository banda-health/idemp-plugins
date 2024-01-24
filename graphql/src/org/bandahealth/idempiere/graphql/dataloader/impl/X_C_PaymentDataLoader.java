package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MPayment_BH;

/**
 * Data Loader for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentDataLoader extends PODataLoader<MPayment_BH> {
	public static String DATALOADER_C_Payment_BY_ID = "C_PaymentByIdDataLoader";
	public static String DATALOADER_C_Payment_BY_UUID = "C_PaymentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPayment_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Payment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Payment_BY_UUID;
	}
}
