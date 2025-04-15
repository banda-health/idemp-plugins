package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_S_Training;

/**
 * Data Loader for S_Training - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_TrainingDataLoader extends PODataLoader<X_S_Training> {
	public static String DATALOADER_S_Training_BY_ID = "S_TrainingByIdDataLoader";
	public static String DATALOADER_S_Training_BY_UUID = "S_TrainingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_S_Training.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_Training_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_Training_BY_UUID;
	}
}
