package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxDeclarationAcct;

/**
 * Data Loader for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDeclarationAcctDataLoader extends PODataLoader<MTaxDeclarationAcct> {
	public static String C_TaxDeclarationAcct_BY_ID_DATA_LOADER = "C_TaxDeclarationAcctByIdDataLoader";
	public static String C_TaxDeclarationAcct_BY_UUID_DATA_LOADER = "C_TaxDeclarationAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxDeclarationAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxDeclarationAcct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxDeclarationAcct_BY_UUID_DATA_LOADER;
	}
}
