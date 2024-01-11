package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodePR;

/**
 * Data Loader for AD_TreeNodePR - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodePRDataLoader extends PODataLoader<MTree_NodePR> {
	public static String AD_TreeNodePR_BY_ID_DATA_LOADER = "AD_TreeNodePRByIdDataLoader";
	public static String AD_TreeNodePR_BY_UUID_DATA_LOADER = "AD_TreeNodePRByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodePR.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TreeNodePR_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TreeNodePR_BY_UUID_DATA_LOADER;
	}
}
