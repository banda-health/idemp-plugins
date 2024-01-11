package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_TopicCategory;

/**
 * Data Loader for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicCategoryDataLoader extends PODataLoader<X_B_TopicCategory> {
	public static String B_TopicCategory_BY_ID_DATA_LOADER = "B_TopicCategoryByIdDataLoader";
	public static String B_TopicCategory_BY_UUID_DATA_LOADER = "B_TopicCategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_TopicCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_TopicCategory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_TopicCategory_BY_UUID_DATA_LOADER;
	}
}
