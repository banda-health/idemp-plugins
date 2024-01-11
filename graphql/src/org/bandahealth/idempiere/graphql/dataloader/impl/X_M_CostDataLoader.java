package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCost;

/**
 * Data Loader for M_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostDataLoader extends PODataLoader<MCost> {
	public static String M_Cost_BY_ID_DATA_LOADER = "M_CostByIdDataLoader";
	public static String M_Cost_BY_UUID_DATA_LOADER = "M_CostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Cost_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Cost_BY_UUID_DATA_LOADER;
	}
}
