package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_FormDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Form;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for ASP_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_FormQuery extends POQuery<X_ASP_Form> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Form.Table_Name;
	}

	public CompletableFuture<X_ASP_Form> ASP_Form(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_ASP_Form> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_ASP_FormDataLoader.DATALOADER_ASP_Form_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_ASP_Form> ASP_FormGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
