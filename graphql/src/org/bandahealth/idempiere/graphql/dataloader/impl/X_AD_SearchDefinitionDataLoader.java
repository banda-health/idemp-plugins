package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSearchDefinition;

/**
 * Data Loader for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SearchDefinitionDataLoader extends PODataLoader<MSearchDefinition> {
	public static String DATALOADER_AD_SearchDefinition_BY_ID = "AD_SearchDefinitionByIdDataLoader";
	public static String DATALOADER_AD_SearchDefinition_BY_UUID = "AD_SearchDefinitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSearchDefinition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_SearchDefinition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_SearchDefinition_BY_UUID;
	}
}
