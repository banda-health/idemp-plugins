package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOSPayment;

/**
 * Data Loader for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSPaymentDataLoader extends PODataLoader<MPOSPayment> {
	public static String DATALOADER_C_POSPayment_BY_ID = "C_POSPaymentByIdDataLoader";
	public static String DATALOADER_C_POSPayment_BY_UUID = "C_POSPaymentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOSPayment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_POSPayment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_POSPayment_BY_UUID;
	}
}
