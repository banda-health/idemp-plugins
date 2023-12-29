package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_ShippingAcct;

/**
 * Data Loader for C_BP_ShippingAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_ShippingAcctDataLoader extends PODataLoader<X_C_BP_ShippingAcct> {
	public static String C_BP_ShippingAcct_BY_ID_DATA_LOADER = "C_BP_ShippingAcctByIdDataLoader";
	public static String C_BP_ShippingAcct_BY_UUID_DATA_LOADER = "C_BP_ShippingAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_ShippingAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BP_ShippingAcct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BP_ShippingAcct_BY_UUID_DATA_LOADER;
	}
}
