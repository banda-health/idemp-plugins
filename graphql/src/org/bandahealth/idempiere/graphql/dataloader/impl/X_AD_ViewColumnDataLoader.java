package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MViewColumn;

/**
 * Data Loader for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ViewColumnDataLoader extends PODataLoader<MViewColumn> {
	public static String DATALOADER_AD_ViewColumn_BY_ID = "AD_ViewColumnByIdDataLoader";
	public static String DATALOADER_AD_ViewColumn_BY_UUID = "AD_ViewColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MViewColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ViewColumn_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ViewColumn_BY_UUID;
	}
}
