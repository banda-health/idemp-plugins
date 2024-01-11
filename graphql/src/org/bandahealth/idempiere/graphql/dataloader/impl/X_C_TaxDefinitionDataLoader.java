package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxDefinition;

/**
 * Data Loader for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDefinitionDataLoader extends PODataLoader<X_C_TaxDefinition> {
	public static String C_TaxDefinition_BY_ID_DATA_LOADER = "C_TaxDefinitionByIdDataLoader";
	public static String C_TaxDefinition_BY_UUID_DATA_LOADER = "C_TaxDefinitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxDefinition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_TaxDefinition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_TaxDefinition_BY_UUID_DATA_LOADER;
	}
}
