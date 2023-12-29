package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_SalesStage;

/**
 * Data Loader for C_SalesStage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SalesStageDataLoader extends PODataLoader<X_C_SalesStage> {
	public static String C_SalesStage_BY_ID_DATA_LOADER = "C_SalesStageByIdDataLoader";
	public static String C_SalesStage_BY_UUID_DATA_LOADER = "C_SalesStageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_SalesStage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_SalesStage_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_SalesStage_BY_UUID_DATA_LOADER;
	}
}
