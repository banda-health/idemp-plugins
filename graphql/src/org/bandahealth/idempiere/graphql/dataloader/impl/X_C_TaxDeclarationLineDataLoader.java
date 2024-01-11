package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxDeclarationLine;

/**
 * Data Loader for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDeclarationLineDataLoader extends PODataLoader<MTaxDeclarationLine> {
	public static String C_TaxDeclarationLine_BY_ID_DATA_LOADER = "C_TaxDeclarationLineByIdDataLoader";
	public static String C_TaxDeclarationLine_BY_UUID_DATA_LOADER = "C_TaxDeclarationLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxDeclarationLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxDeclarationLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxDeclarationLine_BY_UUID_DATA_LOADER;
	}
}
