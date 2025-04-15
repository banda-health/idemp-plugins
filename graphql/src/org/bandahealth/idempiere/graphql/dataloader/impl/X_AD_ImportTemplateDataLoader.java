package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MImportTemplate;

/**
 * Data Loader for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ImportTemplateDataLoader extends PODataLoader<MImportTemplate> {
	public static String DATALOADER_AD_ImportTemplate_BY_ID = "AD_ImportTemplateByIdDataLoader";
	public static String DATALOADER_AD_ImportTemplate_BY_UUID = "AD_ImportTemplateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MImportTemplate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ImportTemplate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ImportTemplate_BY_UUID;
	}
}
