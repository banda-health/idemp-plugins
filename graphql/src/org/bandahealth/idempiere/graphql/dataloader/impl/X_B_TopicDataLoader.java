package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_Topic;

/**
 * Data Loader for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicDataLoader extends PODataLoader<X_B_Topic> {
	public static String DATALOADER_B_Topic_BY_ID = "B_TopicByIdDataLoader";
	public static String DATALOADER_B_Topic_BY_UUID = "B_TopicByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_Topic.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_B_Topic_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_B_Topic_BY_UUID;
	}
}
