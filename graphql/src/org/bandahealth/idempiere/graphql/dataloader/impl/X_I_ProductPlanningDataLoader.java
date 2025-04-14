package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_I_ProductPlanning;

/**
 * Data Loader for I_ProductPlanning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_ProductPlanningDataLoader extends PODataLoader<X_I_ProductPlanning> {
	public static String DATALOADER_I_ProductPlanning_BY_ID = "I_ProductPlanningByIdDataLoader";
	public static String DATALOADER_I_ProductPlanning_BY_UUID = "I_ProductPlanningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_ProductPlanning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_ProductPlanning_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_ProductPlanning_BY_UUID;
	}
}
