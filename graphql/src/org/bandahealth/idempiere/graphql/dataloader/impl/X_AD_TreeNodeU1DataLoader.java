package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeU1;

/**
 * Data Loader for AD_TreeNodeU1 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodeU1DataLoader extends PODataLoader<X_AD_TreeNodeU1> {
	public static String DATALOADER_AD_TreeNodeU1_BY_ID = "AD_TreeNodeU1ByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeU1_BY_UUID = "AD_TreeNodeU1ByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU1.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeU1_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeU1_BY_UUID;
	}
}
