package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_PrintGraph;

/**
 * Data Loader for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintGraphDataLoader extends PODataLoader<X_AD_PrintGraph> {
	public static String AD_PrintGraph_BY_ID_DATA_LOADER = "AD_PrintGraphByIdDataLoader";
	public static String AD_PrintGraph_BY_UUID_DATA_LOADER = "AD_PrintGraphByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_PrintGraph.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PrintGraph_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PrintGraph_BY_UUID_DATA_LOADER;
	}
}
