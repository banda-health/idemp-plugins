package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAllocationLine;

/**
 * Data Loader for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AllocationLineDataLoader extends PODataLoader<MAllocationLine> {
	public static String C_AllocationLine_BY_ID_DATA_LOADER = "C_AllocationLineByIdDataLoader";
	public static String C_AllocationLine_BY_UUID_DATA_LOADER = "C_AllocationLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAllocationLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AllocationLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AllocationLine_BY_UUID_DATA_LOADER;
	}
}
