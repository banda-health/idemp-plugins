package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Asset_Info_Fin;

/**
 * Data Loader for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_Info_FinDataLoader extends PODataLoader<X_A_Asset_Info_Fin> {
	public static String DATALOADER_A_Asset_Info_Fin_BY_ID = "A_Asset_Info_FinByIdDataLoader";
	public static String DATALOADER_A_Asset_Info_Fin_BY_UUID = "A_Asset_Info_FinByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Fin.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Info_Fin_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Info_Fin_BY_UUID;
	}
}
