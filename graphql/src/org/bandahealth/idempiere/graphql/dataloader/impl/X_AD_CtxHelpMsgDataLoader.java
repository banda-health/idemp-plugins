package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCtxHelpMsg;

/**
 * Data Loader for AD_CtxHelpMsg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpMsgDataLoader extends PODataLoader<MCtxHelpMsg> {
	public static String DATALOADER_AD_CtxHelpMsg_BY_ID = "AD_CtxHelpMsgByIdDataLoader";
	public static String DATALOADER_AD_CtxHelpMsg_BY_UUID = "AD_CtxHelpMsgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCtxHelpMsg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_CtxHelpMsg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_CtxHelpMsg_BY_UUID;
	}
}
