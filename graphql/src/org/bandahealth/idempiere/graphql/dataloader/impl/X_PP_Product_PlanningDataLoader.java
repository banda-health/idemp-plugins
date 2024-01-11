package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MPPProductPlanning;

/**
 * Data Loader for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_PlanningDataLoader extends PODataLoader<MPPProductPlanning> {
	public static String PP_Product_Planning_BY_ID_DATA_LOADER = "PP_Product_PlanningByIdDataLoader";
	public static String PP_Product_Planning_BY_UUID_DATA_LOADER = "PP_Product_PlanningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPPProductPlanning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Product_Planning_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Product_Planning_BY_UUID_DATA_LOADER;
	}
}
