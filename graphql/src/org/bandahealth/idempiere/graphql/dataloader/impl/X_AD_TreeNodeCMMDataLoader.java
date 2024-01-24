package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeNodeCMM;

/**
 * Data Loader for AD_TreeNodeCMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMMDataLoader extends PODataLoader<X_AD_TreeNodeCMM> {
	public static String DATALOADER_AD_TreeNodeCMM_BY_ID = "AD_TreeNodeCMMByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeCMM_BY_UUID = "AD_TreeNodeCMMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMM_BY_UUID;
	}
}
