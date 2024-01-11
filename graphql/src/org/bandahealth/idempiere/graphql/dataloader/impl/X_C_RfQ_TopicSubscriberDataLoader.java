package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRfQTopicSubscriber;

/**
 * Data Loader for C_RfQ_TopicSubscriber - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQ_TopicSubscriberDataLoader extends PODataLoader<MRfQTopicSubscriber> {
	public static String C_RfQ_TopicSubscriber_BY_ID_DATA_LOADER = "C_RfQ_TopicSubscriberByIdDataLoader";
	public static String C_RfQ_TopicSubscriber_BY_UUID_DATA_LOADER = "C_RfQ_TopicSubscriberByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRfQTopicSubscriber.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_RfQ_TopicSubscriber_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_RfQ_TopicSubscriber_BY_UUID_DATA_LOADER;
	}
}
