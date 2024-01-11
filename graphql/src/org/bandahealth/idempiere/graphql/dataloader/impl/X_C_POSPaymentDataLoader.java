package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_POSPayment;

/**
 * Data Loader for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSPaymentDataLoader extends PODataLoader<X_C_POSPayment> {
	public static String C_POSPayment_BY_ID_DATA_LOADER = "C_POSPaymentByIdDataLoader";
	public static String C_POSPayment_BY_UUID_DATA_LOADER = "C_POSPaymentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_POSPayment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_POSPayment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_POSPayment_BY_UUID_DATA_LOADER;
	}
}
