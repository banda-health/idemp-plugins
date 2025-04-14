package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQTopicSubscriber;

/**
 * Data Loader for C_RfQ_TopicSubscriber - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_RfQ_TopicSubscriberDataLoader extends PODataLoader<MRfQTopicSubscriber> {
	public static String DATALOADER_C_RfQ_TopicSubscriber_BY_ID = "C_RfQ_TopicSubscriberByIdDataLoader";
	public static String DATALOADER_C_RfQ_TopicSubscriber_BY_UUID = "C_RfQ_TopicSubscriberByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQTopicSubscriber.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RfQ_TopicSubscriber_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RfQ_TopicSubscriber_BY_UUID;
	}
}
