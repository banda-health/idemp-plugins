package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_S_Training;

/**
 * Data Loader for S_Training - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_TrainingDataLoader extends PODataLoader<X_S_Training> {
	public static String S_Training_BY_ID_DATA_LOADER = "S_TrainingByIdDataLoader";
	public static String S_Training_BY_UUID_DATA_LOADER = "S_TrainingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_S_Training.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_Training_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_Training_BY_UUID_DATA_LOADER;
	}
}
