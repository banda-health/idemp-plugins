package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Payment;

/**
 * Data Loader for I_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_PaymentDataLoader extends PODataLoader<X_I_Payment> {
	public static String I_Payment_BY_ID_DATA_LOADER = "I_PaymentByIdDataLoader";
	public static String I_Payment_BY_UUID_DATA_LOADER = "I_PaymentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Payment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Payment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Payment_BY_UUID_DATA_LOADER;
	}
}
