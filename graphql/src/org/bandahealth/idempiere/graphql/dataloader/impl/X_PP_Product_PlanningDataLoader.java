package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MPPProductPlanning;

/**
 * Data Loader for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Product_PlanningDataLoader extends PODataLoader<MPPProductPlanning> {
	public static String DATALOADER_PP_Product_Planning_BY_ID = "PP_Product_PlanningByIdDataLoader";
	public static String DATALOADER_PP_Product_Planning_BY_UUID = "PP_Product_PlanningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductPlanning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Product_Planning_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Product_Planning_BY_UUID;
	}
}
