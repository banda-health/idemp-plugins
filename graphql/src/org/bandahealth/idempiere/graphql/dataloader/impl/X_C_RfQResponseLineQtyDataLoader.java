package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQResponseLineQty;

/**
 * Data Loader for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQResponseLineQtyDataLoader extends PODataLoader<MRfQResponseLineQty> {
	public static String C_RfQResponseLineQty_BY_ID_DATA_LOADER = "C_RfQResponseLineQtyByIdDataLoader";
	public static String C_RfQResponseLineQty_BY_UUID_DATA_LOADER = "C_RfQResponseLineQtyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQResponseLineQty.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_RfQResponseLineQty_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_RfQResponseLineQty_BY_UUID_DATA_LOADER;
	}
}
