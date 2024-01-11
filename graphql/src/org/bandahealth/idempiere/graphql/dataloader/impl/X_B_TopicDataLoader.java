package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Topic;

/**
 * Data Loader for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_TopicDataLoader extends PODataLoader<X_B_Topic> {
	public static String B_Topic_BY_ID_DATA_LOADER = "B_TopicByIdDataLoader";
	public static String B_Topic_BY_UUID_DATA_LOADER = "B_TopicByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Topic.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_Topic_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_Topic_BY_UUID_DATA_LOADER;
	}
}
