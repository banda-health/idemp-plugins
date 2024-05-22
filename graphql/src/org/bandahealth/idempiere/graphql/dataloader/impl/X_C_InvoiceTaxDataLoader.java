package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInvoiceTax;

/**
 * Data Loader for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceTaxDataLoader extends PODataLoader<MInvoiceTax> {
	public static String DATALOADER_C_InvoiceTax_BY_ID = "C_InvoiceTaxByIdDataLoader";
	public static String DATALOADER_C_InvoiceTax_BY_UUID = "C_InvoiceTaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInvoiceTax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_InvoiceTax_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_InvoiceTax_BY_UUID;
	}
}
