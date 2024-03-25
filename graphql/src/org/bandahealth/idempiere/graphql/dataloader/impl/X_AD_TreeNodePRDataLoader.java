package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodePR;

/**
 * Data Loader for AD_TreeNodePR - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodePRDataLoader extends PODataLoader<MTree_NodePR> {
	public static String DATALOADER_AD_TreeNodePR_BY_ID = "AD_TreeNodePRByIdDataLoader";
	public static String DATALOADER_AD_TreeNodePR_BY_UUID = "AD_TreeNodePRByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodePR.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodePR_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodePR_BY_UUID;
	}
}
