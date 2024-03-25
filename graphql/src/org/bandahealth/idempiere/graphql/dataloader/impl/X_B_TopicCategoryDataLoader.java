package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_TopicCategory;

/**
 * Data Loader for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicCategoryDataLoader extends PODataLoader<X_B_TopicCategory> {
	public static String DATALOADER_B_TopicCategory_BY_ID = "B_TopicCategoryByIdDataLoader";
	public static String DATALOADER_B_TopicCategory_BY_UUID = "B_TopicCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_TopicCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_TopicCategory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_TopicCategory_BY_UUID;
	}
}
