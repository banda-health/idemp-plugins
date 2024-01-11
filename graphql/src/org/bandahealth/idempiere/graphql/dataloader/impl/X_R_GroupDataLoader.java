package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGroup;

/**
 * Data Loader for R_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_GroupDataLoader extends PODataLoader<MGroup> {
	public static String R_Group_BY_ID_DATA_LOADER = "R_GroupByIdDataLoader";
	public static String R_Group_BY_UUID_DATA_LOADER = "R_GroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_Group_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_Group_BY_UUID_DATA_LOADER;
	}
}
