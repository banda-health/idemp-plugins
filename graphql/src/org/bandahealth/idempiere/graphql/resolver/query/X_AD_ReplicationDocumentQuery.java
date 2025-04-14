package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationDocumentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_ReplicationDocument;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ReplicationDocument - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReplicationDocumentQuery extends POQuery<X_AD_ReplicationDocument> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReplicationDocument.Table_Name;
	}

	public CompletableFuture<X_AD_ReplicationDocument> AD_ReplicationDocument(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_ReplicationDocument> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReplicationDocumentDataLoader.DATALOADER_AD_ReplicationDocument_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_ReplicationDocument> AD_ReplicationDocumentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
