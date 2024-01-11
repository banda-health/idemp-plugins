package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProduction;

/**
 * Data Loader for M_Production - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionDataLoader extends PODataLoader<MProduction> {
	public static String M_Production_BY_ID_DATA_LOADER = "M_ProductionByIdDataLoader";
	public static String M_Production_BY_UUID_DATA_LOADER = "M_ProductionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProduction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Production_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Production_BY_UUID_DATA_LOADER;
	}
}
