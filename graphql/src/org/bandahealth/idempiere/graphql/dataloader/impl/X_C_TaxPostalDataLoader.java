package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTaxPostal;

/**
 * Data Loader for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaxPostalDataLoader extends PODataLoader<MTaxPostal> {
	public static String DATALOADER_C_TaxPostal_BY_ID = "C_TaxPostalByIdDataLoader";
	public static String DATALOADER_C_TaxPostal_BY_UUID = "C_TaxPostalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTaxPostal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxPostal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxPostal_BY_UUID;
	}
}
