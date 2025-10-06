package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDeclarationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxDeclaration;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxDeclaration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationQuery extends POQuery<MTaxDeclaration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxDeclaration.Table_Name;
	}

	public CompletableFuture<MTaxDeclaration> C_TaxDeclaration(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaxDeclaration> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxDeclarationDataLoader.DATALOADER_C_TaxDeclaration_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaxDeclaration> C_TaxDeclarationGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
