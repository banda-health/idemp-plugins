package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_I_ProductPlanning;

/**
 * Data Loader for I_ProductPlanning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ProductPlanningDataLoader extends PODataLoader<X_I_ProductPlanning> {
	public static String I_ProductPlanning_BY_ID_DATA_LOADER = "I_ProductPlanningByIdDataLoader";
	public static String I_ProductPlanning_BY_UUID_DATA_LOADER = "I_ProductPlanningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_ProductPlanning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_ProductPlanning_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_ProductPlanning_BY_UUID_DATA_LOADER;
	}
}
