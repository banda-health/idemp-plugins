package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequestCategory;

/**
 * Data Loader for R_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_CategoryDataLoader extends PODataLoader<MRequestCategory> {
	public static String DATALOADER_R_Category_BY_ID = "R_CategoryByIdDataLoader";
	public static String DATALOADER_R_Category_BY_UUID = "R_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequestCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_Category_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_Category_BY_UUID;
	}
}
