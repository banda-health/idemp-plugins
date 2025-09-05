package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDeclarationLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxDeclarationLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationLineQuery extends POQuery<MTaxDeclarationLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxDeclarationLine.Table_Name;
	}

	public CompletableFuture<MTaxDeclarationLine> C_TaxDeclarationLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaxDeclarationLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxDeclarationLineDataLoader.DATALOADER_C_TaxDeclarationLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaxDeclarationLine> C_TaxDeclarationLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
