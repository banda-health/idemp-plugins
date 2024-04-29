package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeU2;

/**
 * Data Loader for AD_TreeNodeU2 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeU2DataLoader extends PODataLoader<X_AD_TreeNodeU2> {
	public static String DATALOADER_AD_TreeNodeU2_BY_ID = "AD_TreeNodeU2ByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeU2_BY_UUID = "AD_TreeNodeU2ByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU2.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeU2_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeU2_BY_UUID;
	}
}
