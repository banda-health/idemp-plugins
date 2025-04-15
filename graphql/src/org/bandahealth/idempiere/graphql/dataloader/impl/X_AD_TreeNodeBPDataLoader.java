package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTree_NodeBP;

/**
 * Data Loader for AD_TreeNodeBP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodeBPDataLoader extends PODataLoader<MTree_NodeBP> {
	public static String DATALOADER_AD_TreeNodeBP_BY_ID = "AD_TreeNodeBPByIdDataLoader";
	public static String DATALOADER_AD_TreeNodeBP_BY_UUID = "AD_TreeNodeBPByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTree_NodeBP.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeNodeBP_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeNodeBP_BY_UUID;
	}
}
