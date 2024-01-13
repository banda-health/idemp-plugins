package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCtxHelp;

/**
 * Data Loader for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpDataLoader extends PODataLoader<MCtxHelp> {
	public static String DATALOADER_AD_CtxHelp_BY_ID = "AD_CtxHelpByIdDataLoader";
	public static String DATALOADER_AD_CtxHelp_BY_UUID = "AD_CtxHelpByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCtxHelp.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_CtxHelp_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_CtxHelp_BY_UUID;
	}
}
