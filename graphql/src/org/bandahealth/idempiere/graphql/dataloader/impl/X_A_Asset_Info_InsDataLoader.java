package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Info_Ins;

/**
 * Data Loader for A_Asset_Info_Ins - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_InsDataLoader extends PODataLoader<X_A_Asset_Info_Ins> {
	public static String DATALOADER_A_Asset_Info_Ins_BY_ID = "A_Asset_Info_InsByIdDataLoader";
	public static String DATALOADER_A_Asset_Info_Ins_BY_UUID = "A_Asset_Info_InsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Ins.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Info_Ins_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Info_Ins_BY_UUID;
	}
}
