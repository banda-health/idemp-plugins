package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAllocationHdr;

/**
 * Data Loader for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AllocationHdrDataLoader extends PODataLoader<MAllocationHdr> {
	public static String C_AllocationHdr_BY_ID_DATA_LOADER = "C_AllocationHdrByIdDataLoader";
	public static String C_AllocationHdr_BY_UUID_DATA_LOADER = "C_AllocationHdrByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAllocationHdr.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AllocationHdr_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AllocationHdr_BY_UUID_DATA_LOADER;
	}
}
