package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeU3;

/**
 * Data Loader for AD_TreeNodeU3 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeU3DataLoader extends PODataLoader<X_AD_TreeNodeU3> {
	public static String DATALOADER_AD_TreeNodeU3_BY_ID = "AD_TreeNodeU3ByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeU3_BY_UUID = "AD_TreeNodeU3ByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU3.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeU3_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeU3_BY_UUID;
	}
}
