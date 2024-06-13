package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQ_TopicDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQTopic;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQ_TopicQuery extends POQuery<MRfQTopic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQTopic.Table_Name;
	}

	public CompletableFuture<MRfQTopic> C_RfQ_Topic(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQTopic> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQ_TopicDataLoader.DATALOADER_C_RfQ_Topic_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQTopic> C_RfQ_TopicGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
