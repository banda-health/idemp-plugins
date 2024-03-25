package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeCMT;

/**
 * Data Loader for AD_TreeNodeCMT - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeCMTDataLoader extends PODataLoader<X_AD_TreeNodeCMT> {
	public static String DATALOADER_AD_TreeNodeCMT_BY_ID = "AD_TreeNodeCMTByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeCMT_BY_UUID = "AD_TreeNodeCMTByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMT.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMT_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMT_BY_UUID;
	}
}
