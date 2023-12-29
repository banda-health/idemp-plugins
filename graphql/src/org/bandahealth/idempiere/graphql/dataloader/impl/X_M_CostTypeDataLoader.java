package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostType;

/**
 * Data Loader for M_CostType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostTypeDataLoader extends PODataLoader<MCostType> {
	public static String M_CostType_BY_ID_DATA_LOADER = "M_CostTypeByIdDataLoader";
	public static String M_CostType_BY_UUID_DATA_LOADER = "M_CostTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_CostType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_CostType_BY_UUID_DATA_LOADER;
	}
}
