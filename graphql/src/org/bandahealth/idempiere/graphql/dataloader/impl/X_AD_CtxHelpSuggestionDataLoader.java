package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCtxHelpSuggestion;

/**
 * Data Loader for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpSuggestionDataLoader extends PODataLoader<MCtxHelpSuggestion> {
	public static String AD_CtxHelpSuggestion_BY_ID_DATA_LOADER = "AD_CtxHelpSuggestionByIdDataLoader";
	public static String AD_CtxHelpSuggestion_BY_UUID_DATA_LOADER = "AD_CtxHelpSuggestionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCtxHelpSuggestion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_CtxHelpSuggestion_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_CtxHelpSuggestion_BY_UUID_DATA_LOADER;
	}
}
