package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentTerm;

/**
 * Data Loader for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTermDataLoader extends PODataLoader<MPaymentTerm> {
	public static String C_PaymentTerm_BY_ID_DATA_LOADER = "C_PaymentTermByIdDataLoader";
	public static String C_PaymentTerm_BY_UUID_DATA_LOADER = "C_PaymentTermByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentTerm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaymentTerm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaymentTerm_BY_UUID_DATA_LOADER;
	}
}
