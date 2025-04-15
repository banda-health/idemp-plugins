package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxDeclaration;

/**
 * Data Loader for C_TaxDeclaration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationDataLoader extends PODataLoader<MTaxDeclaration> {
	public static String DATALOADER_C_TaxDeclaration_BY_ID = "C_TaxDeclarationByIdDataLoader";
	public static String DATALOADER_C_TaxDeclaration_BY_UUID = "C_TaxDeclarationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxDeclaration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxDeclaration_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxDeclaration_BY_UUID;
	}
}
