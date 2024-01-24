package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProduction;

/**
 * Data Loader for M_Production - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionDataLoader extends PODataLoader<MProduction> {
	public static String DATALOADER_M_Production_BY_ID = "M_ProductionByIdDataLoader";
	public static String DATALOADER_M_Production_BY_UUID = "M_ProductionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProduction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Production_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Production_BY_UUID;
	}
}
