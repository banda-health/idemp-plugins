package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostQueue;

/**
 * Data Loader for M_CostQueue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_CostQueueDataLoader extends PODataLoader<MCostQueue> {
	public static String DATALOADER_M_CostQueue_BY_ID = "M_CostQueueByIdDataLoader";
	public static String DATALOADER_M_CostQueue_BY_UUID = "M_CostQueueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostQueue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_CostQueue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_CostQueue_BY_UUID;
	}
}
