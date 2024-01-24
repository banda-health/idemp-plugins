package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQResponseLineQty;

/**
 * Data Loader for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseLineQtyDataLoader extends PODataLoader<MRfQResponseLineQty> {
	public static String DATALOADER_C_RfQResponseLineQty_BY_ID = "C_RfQResponseLineQtyByIdDataLoader";
	public static String DATALOADER_C_RfQResponseLineQty_BY_UUID = "C_RfQResponseLineQtyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQResponseLineQty.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQResponseLineQty_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQResponseLineQty_BY_UUID;
	}
}
