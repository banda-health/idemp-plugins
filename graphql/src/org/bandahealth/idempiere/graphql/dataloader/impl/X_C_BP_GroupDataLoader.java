package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBPGroup_BH;

/**
 * Data Loader for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_GroupDataLoader extends PODataLoader<MBPGroup_BH> {
	public static String DATALOADER_C_BP_Group_BY_ID = "C_BP_GroupByIdDataLoader";
	public static String DATALOADER_C_BP_Group_BY_UUID = "C_BP_GroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPGroup_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BP_Group_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BP_Group_BY_UUID;
	}
}
