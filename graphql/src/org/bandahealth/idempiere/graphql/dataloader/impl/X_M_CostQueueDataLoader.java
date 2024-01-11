package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostQueue;

/**
 * Data Loader for M_CostQueue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostQueueDataLoader extends PODataLoader<MCostQueue> {
	public static String M_CostQueue_BY_ID_DATA_LOADER = "M_CostQueueByIdDataLoader";
	public static String M_CostQueue_BY_UUID_DATA_LOADER = "M_CostQueueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostQueue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_CostQueue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_CostQueue_BY_UUID_DATA_LOADER;
	}
}
