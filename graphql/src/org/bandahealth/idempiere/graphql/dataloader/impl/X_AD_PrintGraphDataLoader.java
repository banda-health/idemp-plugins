package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintGraph;

/**
 * Data Loader for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintGraphDataLoader extends PODataLoader<X_AD_PrintGraph> {
	public static String DATALOADER_AD_PrintGraph_BY_ID = "AD_PrintGraphByIdDataLoader";
	public static String DATALOADER_AD_PrintGraph_BY_UUID = "AD_PrintGraphByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintGraph.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PrintGraph_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PrintGraph_BY_UUID;
	}
}
