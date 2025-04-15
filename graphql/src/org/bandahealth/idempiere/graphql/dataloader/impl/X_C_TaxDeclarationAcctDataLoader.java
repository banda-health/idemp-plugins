package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxDeclarationAcct;

/**
 * Data Loader for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationAcctDataLoader extends PODataLoader<MTaxDeclarationAcct> {
	public static String DATALOADER_C_TaxDeclarationAcct_BY_ID = "C_TaxDeclarationAcctByIdDataLoader";
	public static String DATALOADER_C_TaxDeclarationAcct_BY_UUID = "C_TaxDeclarationAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxDeclarationAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxDeclarationAcct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxDeclarationAcct_BY_UUID;
	}
}
