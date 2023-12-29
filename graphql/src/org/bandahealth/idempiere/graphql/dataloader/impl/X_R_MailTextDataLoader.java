package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMailText;

/**
 * Data Loader for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_MailTextDataLoader extends PODataLoader<MMailText> {
	public static String R_MailText_BY_ID_DATA_LOADER = "R_MailTextByIdDataLoader";
	public static String R_MailText_BY_UUID_DATA_LOADER = "R_MailTextByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMailText.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_MailText_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_MailText_BY_UUID_DATA_LOADER;
	}
}
