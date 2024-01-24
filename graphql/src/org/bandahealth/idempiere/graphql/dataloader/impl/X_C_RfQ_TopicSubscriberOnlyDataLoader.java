package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQTopicSubscriberOnly;

/**
 * Data Loader for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyDataLoader extends PODataLoader<MRfQTopicSubscriberOnly> {
	public static String DATALOADER_C_RfQ_TopicSubscriberOnly_BY_ID = "C_RfQ_TopicSubscriberOnlyByIdDataLoader";
	public static String DATALOADER_C_RfQ_TopicSubscriberOnly_BY_UUID = "C_RfQ_TopicSubscriberOnlyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQTopicSubscriberOnly.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQ_TopicSubscriberOnly_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQ_TopicSubscriberOnly_BY_UUID;
	}
}
