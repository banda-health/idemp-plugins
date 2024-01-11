package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductionLineMA;

/**
 * Data Loader for M_ProductionLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionLineMADataLoader extends PODataLoader<MProductionLineMA> {
	public static String M_ProductionLineMA_BY_ID_DATA_LOADER = "M_ProductionLineMAByIdDataLoader";
	public static String M_ProductionLineMA_BY_UUID_DATA_LOADER = "M_ProductionLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductionLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductionLineMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductionLineMA_BY_UUID_DATA_LOADER;
	}
}
