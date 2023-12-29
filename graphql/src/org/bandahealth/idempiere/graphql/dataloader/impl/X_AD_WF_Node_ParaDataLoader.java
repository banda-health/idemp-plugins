package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Node_Para;

/**
 * Data Loader for AD_WF_Node_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_Node_ParaDataLoader extends PODataLoader<X_AD_WF_Node_Para> {
	public static String AD_WF_Node_Para_BY_ID_DATA_LOADER = "AD_WF_Node_ParaByIdDataLoader";
	public static String AD_WF_Node_Para_BY_UUID_DATA_LOADER = "AD_WF_Node_ParaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Node_Para.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_Node_Para_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_Node_Para_BY_UUID_DATA_LOADER;
	}
}
