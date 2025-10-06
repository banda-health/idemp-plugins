package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchema;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AcctSchemaQuery extends POQuery<MAcctSchema> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchema.Table_Name;
	}

	public CompletableFuture<MAcctSchema> C_AcctSchema(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAcctSchema> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAcctSchema> C_AcctSchemaGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
