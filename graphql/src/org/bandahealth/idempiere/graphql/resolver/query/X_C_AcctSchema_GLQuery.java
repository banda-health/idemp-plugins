package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchema_GLDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchemaGL;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchema_GLQuery extends POQuery<MAcctSchemaGL> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchemaGL.Table_Name;
	}

	public CompletableFuture<MAcctSchemaGL> C_AcctSchema_GL(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAcctSchemaGL> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AcctSchema_GLDataLoader.DATALOADER_C_AcctSchema_GL_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAcctSchemaGL> C_AcctSchema_GLGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
