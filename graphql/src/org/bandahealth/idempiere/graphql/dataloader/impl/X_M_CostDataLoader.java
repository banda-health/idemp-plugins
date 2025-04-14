package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCost;

/**
 * Data Loader for M_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_CostDataLoader extends PODataLoader<MCost> {
	public static String DATALOADER_M_Cost_BY_ID = "M_CostByIdDataLoader";
	public static String DATALOADER_M_Cost_BY_UUID = "M_CostByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCost.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Cost_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Cost_BY_UUID;
	}
}
