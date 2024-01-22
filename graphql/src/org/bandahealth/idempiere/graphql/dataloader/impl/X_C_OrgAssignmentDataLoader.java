package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_OrgAssignment;

/**
 * Data Loader for C_OrgAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrgAssignmentDataLoader extends PODataLoader<X_C_OrgAssignment> {
	public static String DATALOADER_C_OrgAssignment_BY_ID = "C_OrgAssignmentByIdDataLoader";
	public static String DATALOADER_C_OrgAssignment_BY_UUID = "C_OrgAssignmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_OrgAssignment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrgAssignment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrgAssignment_BY_UUID;
	}
}
