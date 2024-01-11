package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductionLine;

/**
 * Data Loader for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionLineDataLoader extends PODataLoader<MProductionLine> {
	public static String M_ProductionLine_BY_ID_DATA_LOADER = "M_ProductionLineByIdDataLoader";
	public static String M_ProductionLine_BY_UUID_DATA_LOADER = "M_ProductionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductionLine_BY_UUID_DATA_LOADER;
	}
}
