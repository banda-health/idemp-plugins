package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDeclarationAcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxDeclarationAcct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationAcctQuery extends POQuery<MTaxDeclarationAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxDeclarationAcct.Table_Name;
	}

	public CompletableFuture<MTaxDeclarationAcct> C_TaxDeclarationAcct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaxDeclarationAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxDeclarationAcctDataLoader.DATALOADER_C_TaxDeclarationAcct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaxDeclarationAcct> C_TaxDeclarationAcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
