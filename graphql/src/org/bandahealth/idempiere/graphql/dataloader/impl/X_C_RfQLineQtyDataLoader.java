package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQLineQty;

/**
 * Data Loader for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQLineQtyDataLoader extends PODataLoader<MRfQLineQty> {
	public static String C_RfQLineQty_BY_ID_DATA_LOADER = "C_RfQLineQtyByIdDataLoader";
	public static String C_RfQLineQty_BY_UUID_DATA_LOADER = "C_RfQLineQtyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQLineQty.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_RfQLineQty_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_RfQLineQty_BY_UUID_DATA_LOADER;
	}
}
