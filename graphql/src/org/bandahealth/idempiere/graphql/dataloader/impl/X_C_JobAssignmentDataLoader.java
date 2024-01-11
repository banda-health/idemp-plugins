package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_JobAssignment;

/**
 * Data Loader for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobAssignmentDataLoader extends PODataLoader<X_C_JobAssignment> {
	public static String C_JobAssignment_BY_ID_DATA_LOADER = "C_JobAssignmentByIdDataLoader";
	public static String C_JobAssignment_BY_UUID_DATA_LOADER = "C_JobAssignmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_JobAssignment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_JobAssignment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_JobAssignment_BY_UUID_DATA_LOADER;
	}
}
