package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStatusCategory;

/**
 * Data Loader for R_StatusCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StatusCategoryDataLoader extends PODataLoader<MStatusCategory> {
	public static String DATALOADER_R_StatusCategory_BY_ID = "R_StatusCategoryByIdDataLoader";
	public static String DATALOADER_R_StatusCategory_BY_UUID = "R_StatusCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStatusCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_StatusCategory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_StatusCategory_BY_UUID;
	}
}
