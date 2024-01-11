package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxDeclaration;

/**
 * Data Loader for C_TaxDeclaration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDeclarationDataLoader extends PODataLoader<MTaxDeclaration> {
	public static String C_TaxDeclaration_BY_ID_DATA_LOADER = "C_TaxDeclarationByIdDataLoader";
	public static String C_TaxDeclaration_BY_UUID_DATA_LOADER = "C_TaxDeclarationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxDeclaration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxDeclaration_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxDeclaration_BY_UUID_DATA_LOADER;
	}
}
