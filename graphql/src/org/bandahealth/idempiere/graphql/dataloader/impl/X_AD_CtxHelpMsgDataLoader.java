package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCtxHelpMsg;

/**
 * Data Loader for AD_CtxHelpMsg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpMsgDataLoader extends PODataLoader<MCtxHelpMsg> {
	public static String AD_CtxHelpMsg_BY_ID_DATA_LOADER = "AD_CtxHelpMsgByIdDataLoader";
	public static String AD_CtxHelpMsg_BY_UUID_DATA_LOADER = "AD_CtxHelpMsgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCtxHelpMsg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_CtxHelpMsg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_CtxHelpMsg_BY_UUID_DATA_LOADER;
	}
}
