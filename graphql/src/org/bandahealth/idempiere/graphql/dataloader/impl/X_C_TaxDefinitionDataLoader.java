package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_C_TaxDefinition;

/**
 * Data Loader for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxDefinitionDataLoader extends PODataLoader<X_C_TaxDefinition> {
	public static String DATALOADER_C_TaxDefinition_BY_ID = "C_TaxDefinitionByIdDataLoader";
	public static String DATALOADER_C_TaxDefinition_BY_UUID = "C_TaxDefinitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_TaxDefinition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_TaxDefinition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_TaxDefinition_BY_UUID;
	}
}
