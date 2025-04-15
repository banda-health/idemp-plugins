package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Node;

/**
 * Data Loader for AD_WF_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_NodeDataLoader extends PODataLoader<X_AD_WF_Node> {
	public static String DATALOADER_AD_WF_Node_BY_ID = "AD_WF_NodeByIdDataLoader";
	public static String DATALOADER_AD_WF_Node_BY_UUID = "AD_WF_NodeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Node.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WF_Node_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WF_Node_BY_UUID;
	}
}
