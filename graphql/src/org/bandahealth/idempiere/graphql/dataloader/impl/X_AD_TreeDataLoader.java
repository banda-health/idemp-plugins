package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MTree_BH;

/**
 * Data Loader for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeDataLoader extends PODataLoader<MTree_BH> {
	public static String DATALOADER_AD_Tree_BY_ID = "AD_TreeByIdDataLoader";
	public static String DATALOADER_AD_Tree_BY_UUID = "AD_TreeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Tree_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Tree_BY_UUID;
	}
}
