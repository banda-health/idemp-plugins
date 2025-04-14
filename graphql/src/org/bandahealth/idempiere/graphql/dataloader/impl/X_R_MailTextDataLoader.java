package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMailText;

/**
 * Data Loader for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_MailTextDataLoader extends PODataLoader<MMailText> {
	public static String DATALOADER_R_MailText_BY_ID = "R_MailTextByIdDataLoader";
	public static String DATALOADER_R_MailText_BY_UUID = "R_MailTextByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMailText.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_MailText_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_MailText_BY_UUID;
	}
}
