package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAllocationLine;

/**
 * Data Loader for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AllocationLineDataLoader extends PODataLoader<MAllocationLine> {
	public static String DATALOADER_C_AllocationLine_BY_ID = "C_AllocationLineByIdDataLoader";
	public static String DATALOADER_C_AllocationLine_BY_UUID = "C_AllocationLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAllocationLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AllocationLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AllocationLine_BY_UUID;
	}
}
