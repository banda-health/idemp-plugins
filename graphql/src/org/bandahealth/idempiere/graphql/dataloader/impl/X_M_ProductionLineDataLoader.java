package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductionLine;

/**
 * Data Loader for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductionLineDataLoader extends PODataLoader<MProductionLine> {
	public static String DATALOADER_M_ProductionLine_BY_ID = "M_ProductionLineByIdDataLoader";
	public static String DATALOADER_M_ProductionLine_BY_UUID = "M_ProductionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ProductionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ProductionLine_BY_UUID;
	}
}
