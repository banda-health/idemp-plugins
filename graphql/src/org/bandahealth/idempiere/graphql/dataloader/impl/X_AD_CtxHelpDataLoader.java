package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCtxHelp;

/**
 * Data Loader for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpDataLoader extends PODataLoader<MCtxHelp> {
	public static String AD_CtxHelp_BY_ID_DATA_LOADER = "AD_CtxHelpByIdDataLoader";
	public static String AD_CtxHelp_BY_UUID_DATA_LOADER = "AD_CtxHelpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCtxHelp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_CtxHelp_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_CtxHelp_BY_UUID_DATA_LOADER;
	}
}
