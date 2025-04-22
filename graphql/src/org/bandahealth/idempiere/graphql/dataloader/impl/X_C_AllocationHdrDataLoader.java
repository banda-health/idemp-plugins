package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAllocationHdr;

/**
 * Data Loader for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AllocationHdrDataLoader extends PODataLoader<MAllocationHdr> {
	public static String DATALOADER_C_AllocationHdr_BY_ID = "C_AllocationHdrByIdDataLoader";
	public static String DATALOADER_C_AllocationHdr_BY_UUID = "C_AllocationHdrByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAllocationHdr.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AllocationHdr_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AllocationHdr_BY_UUID;
	}
}
