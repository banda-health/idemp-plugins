package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSearchDefinition;

/**
 * Data Loader for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SearchDefinitionDataLoader extends PODataLoader<MSearchDefinition> {
	public static String AD_SearchDefinition_BY_ID_DATA_LOADER = "AD_SearchDefinitionByIdDataLoader";
	public static String AD_SearchDefinition_BY_UUID_DATA_LOADER = "AD_SearchDefinitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSearchDefinition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_SearchDefinition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_SearchDefinition_BY_UUID_DATA_LOADER;
	}
}
