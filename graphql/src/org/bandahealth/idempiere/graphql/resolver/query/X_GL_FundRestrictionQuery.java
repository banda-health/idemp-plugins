package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_FundRestrictionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_FundRestriction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_FundRestrictionQuery extends POQuery<X_GL_FundRestriction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_FundRestriction.Table_Name;
	}

	public CompletableFuture<X_GL_FundRestriction> GL_FundRestriction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_GL_FundRestriction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_FundRestrictionDataLoader.DATALOADER_GL_FundRestriction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_GL_FundRestriction> GL_FundRestrictionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
