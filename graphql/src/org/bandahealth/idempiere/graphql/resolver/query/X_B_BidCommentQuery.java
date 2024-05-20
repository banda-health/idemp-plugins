package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_BidCommentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_BidComment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_BidCommentQuery extends POQuery<X_B_BidComment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_BidComment.Table_Name;
	}

	public CompletableFuture<X_B_BidComment> B_BidComment(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_BidComment> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_BidCommentDataLoader.DATALOADER_B_BidComment_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_BidComment> B_BidCommentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
