package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostType;

/**
 * Data Loader for M_CostType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostTypeDataLoader extends PODataLoader<MCostType> {
	public static String DATALOADER_M_CostType_BY_ID = "M_CostTypeByIdDataLoader";
	public static String DATALOADER_M_CostType_BY_UUID = "M_CostTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_CostType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_CostType_BY_UUID;
	}
}
