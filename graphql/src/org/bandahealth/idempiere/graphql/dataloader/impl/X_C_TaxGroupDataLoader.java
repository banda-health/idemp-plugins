package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxGroup;

/**
 * Data Loader for C_TaxGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxGroupDataLoader extends PODataLoader<X_C_TaxGroup> {
	public static String DATALOADER_C_TaxGroup_BY_ID = "C_TaxGroupByIdDataLoader";
	public static String DATALOADER_C_TaxGroup_BY_UUID = "C_TaxGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxGroup_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxGroup_BY_UUID;
	}
}
