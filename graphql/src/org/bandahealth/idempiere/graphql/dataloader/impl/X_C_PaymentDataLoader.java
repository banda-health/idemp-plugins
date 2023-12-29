package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MPayment_BH;

/**
 * Data Loader for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentDataLoader extends PODataLoader<MPayment_BH> {
	public static String C_Payment_BY_ID_DATA_LOADER = "C_PaymentByIdDataLoader";
	public static String C_Payment_BY_UUID_DATA_LOADER = "C_PaymentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPayment_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Payment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Payment_BY_UUID_DATA_LOADER;
	}
}
