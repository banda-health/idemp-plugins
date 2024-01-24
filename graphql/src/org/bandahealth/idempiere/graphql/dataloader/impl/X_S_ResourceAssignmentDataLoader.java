package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResourceAssignment;

/**
 * Data Loader for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceAssignmentDataLoader extends PODataLoader<MResourceAssignment> {
	public static String DATALOADER_S_ResourceAssignment_BY_ID = "S_ResourceAssignmentByIdDataLoader";
	public static String DATALOADER_S_ResourceAssignment_BY_UUID = "S_ResourceAssignmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResourceAssignment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_ResourceAssignment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_ResourceAssignment_BY_UUID;
	}
}
