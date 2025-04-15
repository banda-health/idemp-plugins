package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxDeclarationLine;

/**
 * Data Loader for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationLineDataLoader extends PODataLoader<MTaxDeclarationLine> {
	public static String DATALOADER_C_TaxDeclarationLine_BY_ID = "C_TaxDeclarationLineByIdDataLoader";
	public static String DATALOADER_C_TaxDeclarationLine_BY_UUID = "C_TaxDeclarationLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxDeclarationLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxDeclarationLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxDeclarationLine_BY_UUID;
	}
}
