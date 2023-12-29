package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResourceAssignment;

/**
 * Data Loader for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceAssignmentDataLoader extends PODataLoader<MResourceAssignment> {
	public static String S_ResourceAssignment_BY_ID_DATA_LOADER = "S_ResourceAssignmentByIdDataLoader";
	public static String S_ResourceAssignment_BY_UUID_DATA_LOADER = "S_ResourceAssignmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResourceAssignment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_ResourceAssignment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_ResourceAssignment_BY_UUID_DATA_LOADER;
	}
}
