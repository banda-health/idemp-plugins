package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Payment;

/**
 * Data Loader for I_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_PaymentDataLoader extends PODataLoader<X_I_Payment> {
	public static String DATALOADER_I_Payment_BY_ID = "I_PaymentByIdDataLoader";
	public static String DATALOADER_I_Payment_BY_UUID = "I_PaymentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Payment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Payment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Payment_BY_UUID;
	}
}
