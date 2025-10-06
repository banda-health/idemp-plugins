package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchema_DefaultDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchemaDefault;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AcctSchema_DefaultQuery extends POQuery<MAcctSchemaDefault> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchemaDefault.Table_Name;
	}

	public CompletableFuture<MAcctSchemaDefault> C_AcctSchema_Default(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAcctSchemaDefault> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AcctSchema_DefaultDataLoader.DATALOADER_C_AcctSchema_Default_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAcctSchemaDefault> C_AcctSchema_DefaultGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
