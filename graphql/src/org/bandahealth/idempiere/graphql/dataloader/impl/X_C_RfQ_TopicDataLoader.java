package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQTopic;

/**
 * Data Loader for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQ_TopicDataLoader extends PODataLoader<MRfQTopic> {
	public static String DATALOADER_C_RfQ_Topic_BY_ID = "C_RfQ_TopicByIdDataLoader";
	public static String DATALOADER_C_RfQ_Topic_BY_UUID = "C_RfQ_TopicByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQTopic.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQ_Topic_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQ_Topic_BY_UUID;
	}
}
