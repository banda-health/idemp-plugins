package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_OrgAssignment;

/**
 * Data Loader for C_OrgAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrgAssignmentDataLoader extends PODataLoader<X_C_OrgAssignment> {
	public static String C_OrgAssignment_BY_ID_DATA_LOADER = "C_OrgAssignmentByIdDataLoader";
	public static String C_OrgAssignment_BY_UUID_DATA_LOADER = "C_OrgAssignmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_OrgAssignment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrgAssignment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrgAssignment_BY_UUID_DATA_LOADER;
	}
}
