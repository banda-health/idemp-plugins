package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MFieldSuggestion;

/**
 * Data Loader for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FieldSuggestionDataLoader extends PODataLoader<MFieldSuggestion> {
	public static String AD_FieldSuggestion_BY_ID_DATA_LOADER = "AD_FieldSuggestionByIdDataLoader";
	public static String AD_FieldSuggestion_BY_UUID_DATA_LOADER = "AD_FieldSuggestionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFieldSuggestion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_FieldSuggestion_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_FieldSuggestion_BY_UUID_DATA_LOADER;
	}
}
