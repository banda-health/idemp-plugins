package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_NodeNext;

/**
 * Data Loader for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WF_NodeNextDataLoader extends PODataLoader<X_AD_WF_NodeNext> {
	public static String DATALOADER_AD_WF_NodeNext_BY_ID = "AD_WF_NodeNextByIdDataLoader";
	public static String DATALOADER_AD_WF_NodeNext_BY_UUID = "AD_WF_NodeNextByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_NodeNext.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WF_NodeNext_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WF_NodeNext_BY_UUID;
	}
}
