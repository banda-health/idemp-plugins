package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBPGroup_BH;

/**
 * Data Loader for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_GroupDataLoader extends PODataLoader<MBPGroup_BH> {
	public static String C_BP_Group_BY_ID_DATA_LOADER = "C_BP_GroupByIdDataLoader";
	public static String C_BP_Group_BY_UUID_DATA_LOADER = "C_BP_GroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPGroup_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_BP_Group_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_BP_Group_BY_UUID_DATA_LOADER;
	}
}
