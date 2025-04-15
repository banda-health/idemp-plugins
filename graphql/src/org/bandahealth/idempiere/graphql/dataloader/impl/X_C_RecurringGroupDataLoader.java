package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_RecurringGroup;

/**
 * Data Loader for C_RecurringGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RecurringGroupDataLoader extends PODataLoader<X_C_RecurringGroup> {
	public static String DATALOADER_C_RecurringGroup_BY_ID = "C_RecurringGroupByIdDataLoader";
	public static String DATALOADER_C_RecurringGroup_BY_UUID = "C_RecurringGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_RecurringGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RecurringGroup_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RecurringGroup_BY_UUID;
	}
}
