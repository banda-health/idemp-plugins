package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_BP_ShippingAcct;

/**
 * Data Loader for C_BP_ShippingAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BP_ShippingAcctDataLoader extends PODataLoader<X_C_BP_ShippingAcct> {
	public static String DATALOADER_C_BP_ShippingAcct_BY_ID = "C_BP_ShippingAcctByIdDataLoader";
	public static String DATALOADER_C_BP_ShippingAcct_BY_UUID = "C_BP_ShippingAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_BP_ShippingAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BP_ShippingAcct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BP_ShippingAcct_BY_UUID;
	}
}
