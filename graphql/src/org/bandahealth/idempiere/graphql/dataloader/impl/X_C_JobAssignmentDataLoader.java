package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_JobAssignment;

/**
 * Data Loader for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_JobAssignmentDataLoader extends PODataLoader<X_C_JobAssignment> {
	public static String DATALOADER_C_JobAssignment_BY_ID = "C_JobAssignmentByIdDataLoader";
	public static String DATALOADER_C_JobAssignment_BY_UUID = "C_JobAssignmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_JobAssignment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_JobAssignment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_JobAssignment_BY_UUID;
	}
}
