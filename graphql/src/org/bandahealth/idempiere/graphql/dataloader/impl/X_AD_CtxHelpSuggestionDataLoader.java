package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCtxHelpSuggestion;

/**
 * Data Loader for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_CtxHelpSuggestionDataLoader extends PODataLoader<MCtxHelpSuggestion> {
	public static String DATALOADER_AD_CtxHelpSuggestion_BY_ID = "AD_CtxHelpSuggestionByIdDataLoader";
	public static String DATALOADER_AD_CtxHelpSuggestion_BY_UUID = "AD_CtxHelpSuggestionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCtxHelpSuggestion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_CtxHelpSuggestion_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_CtxHelpSuggestion_BY_UUID;
	}
}
