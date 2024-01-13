package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Info_Tax;

/**
 * Data Loader for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_TaxDataLoader extends PODataLoader<X_A_Asset_Info_Tax> {
	public static String DATALOADER_A_Asset_Info_Tax_BY_ID = "A_Asset_Info_TaxByIdDataLoader";
	public static String DATALOADER_A_Asset_Info_Tax_BY_UUID = "A_Asset_Info_TaxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Tax.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Info_Tax_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Info_Tax_BY_UUID;
	}
}
