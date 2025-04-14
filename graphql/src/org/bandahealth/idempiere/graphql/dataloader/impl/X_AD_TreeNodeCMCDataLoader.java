package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeCMC;

/**
 * Data Loader for AD_TreeNodeCMC - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TreeNodeCMCDataLoader extends PODataLoader<MTree_NodeCMC> {
	public static String DATALOADER_AD_TreeNodeCMC_BY_ID = "AD_TreeNodeCMCByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeCMC_BY_UUID = "AD_TreeNodeCMCByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeCMC.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMC_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeCMC_BY_UUID;
	}
}
