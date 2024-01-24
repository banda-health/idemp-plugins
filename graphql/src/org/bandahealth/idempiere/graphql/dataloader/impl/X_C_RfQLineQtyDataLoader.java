package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQLineQty;

/**
 * Data Loader for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQLineQtyDataLoader extends PODataLoader<MRfQLineQty> {
	public static String DATALOADER_C_RfQLineQty_BY_ID = "C_RfQLineQtyByIdDataLoader";
	public static String DATALOADER_C_RfQLineQty_BY_UUID = "C_RfQLineQtyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQLineQty.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQLineQty_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQLineQty_BY_UUID;
	}
}
