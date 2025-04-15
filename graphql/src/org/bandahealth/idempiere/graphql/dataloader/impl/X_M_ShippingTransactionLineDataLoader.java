package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShippingTransactionLine;

/**
 * Data Loader for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShippingTransactionLineDataLoader extends PODataLoader<MShippingTransactionLine> {
	public static String DATALOADER_M_ShippingTransactionLine_BY_ID = "M_ShippingTransactionLineByIdDataLoader";
	public static String DATALOADER_M_ShippingTransactionLine_BY_UUID = "M_ShippingTransactionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShippingTransactionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShippingTransactionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShippingTransactionLine_BY_UUID;
	}
}
