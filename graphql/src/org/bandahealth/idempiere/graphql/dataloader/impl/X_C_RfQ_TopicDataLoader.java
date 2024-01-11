package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQTopic;

/**
 * Data Loader for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQ_TopicDataLoader extends PODataLoader<MRfQTopic> {
	public static String C_RfQ_Topic_BY_ID_DATA_LOADER = "C_RfQ_TopicByIdDataLoader";
	public static String C_RfQ_Topic_BY_UUID_DATA_LOADER = "C_RfQ_TopicByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQTopic.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_RfQ_Topic_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_RfQ_Topic_BY_UUID_DATA_LOADER;
	}
}
