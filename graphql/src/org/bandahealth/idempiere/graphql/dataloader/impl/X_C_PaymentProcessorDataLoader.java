package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentProcessor;

/**
 * Data Loader for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentProcessorDataLoader extends PODataLoader<MPaymentProcessor> {
	public static String C_PaymentProcessor_BY_ID_DATA_LOADER = "C_PaymentProcessorByIdDataLoader";
	public static String C_PaymentProcessor_BY_UUID_DATA_LOADER = "C_PaymentProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaymentProcessor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaymentProcessor_BY_UUID_DATA_LOADER;
	}
}
