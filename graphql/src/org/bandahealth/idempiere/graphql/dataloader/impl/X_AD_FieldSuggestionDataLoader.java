package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFieldSuggestion;

/**
 * Data Loader for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_FieldSuggestionDataLoader extends PODataLoader<MFieldSuggestion> {
	public static String DATALOADER_AD_FieldSuggestion_BY_ID = "AD_FieldSuggestionByIdDataLoader";
	public static String DATALOADER_AD_FieldSuggestion_BY_UUID = "AD_FieldSuggestionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFieldSuggestion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_FieldSuggestion_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_FieldSuggestion_BY_UUID;
	}
}
