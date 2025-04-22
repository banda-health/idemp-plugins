package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_SalesStage;

/**
 * Data Loader for C_SalesStage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_SalesStageDataLoader extends PODataLoader<X_C_SalesStage> {
	public static String DATALOADER_C_SalesStage_BY_ID = "C_SalesStageByIdDataLoader";
	public static String DATALOADER_C_SalesStage_BY_UUID = "C_SalesStageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_SalesStage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_SalesStage_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_SalesStage_BY_UUID;
	}
}
