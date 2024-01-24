package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxBase;

/**
 * Data Loader for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxBaseDataLoader extends PODataLoader<X_C_TaxBase> {
	public static String DATALOADER_C_TaxBase_BY_ID = "C_TaxBaseByIdDataLoader";
	public static String DATALOADER_C_TaxBase_BY_UUID = "C_TaxBaseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxBase.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxBase_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxBase_BY_UUID;
	}
}
