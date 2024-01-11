package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MImportTemplate;

/**
 * Data Loader for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImportTemplateDataLoader extends PODataLoader<MImportTemplate> {
	public static String AD_ImportTemplate_BY_ID_DATA_LOADER = "AD_ImportTemplateByIdDataLoader";
	public static String AD_ImportTemplate_BY_UUID_DATA_LOADER = "AD_ImportTemplateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MImportTemplate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ImportTemplate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ImportTemplate_BY_UUID_DATA_LOADER;
	}
}
