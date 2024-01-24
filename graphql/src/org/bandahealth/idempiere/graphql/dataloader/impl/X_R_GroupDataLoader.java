package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGroup;

/**
 * Data Loader for R_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_GroupDataLoader extends PODataLoader<MGroup> {
	public static String DATALOADER_R_Group_BY_ID = "R_GroupByIdDataLoader";
	public static String DATALOADER_R_Group_BY_UUID = "R_GroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_Group_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_Group_BY_UUID;
	}
}
