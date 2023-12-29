package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTax;

/**
 * Data Loader for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDataLoader extends PODataLoader<MTax> {
	public static String C_Tax_BY_ID_DATA_LOADER = "C_TaxByIdDataLoader";
	public static String C_Tax_BY_UUID_DATA_LOADER = "C_TaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Tax_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Tax_BY_UUID_DATA_LOADER;
	}
}
