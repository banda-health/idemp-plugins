package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_TopicType;

/**
 * Data Loader for B_TopicType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicTypeDataLoader extends PODataLoader<X_B_TopicType> {
	public static String B_TopicType_BY_ID_DATA_LOADER = "B_TopicTypeByIdDataLoader";
	public static String B_TopicType_BY_UUID_DATA_LOADER = "B_TopicTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_TopicType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_TopicType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_TopicType_BY_UUID_DATA_LOADER;
	}
}
