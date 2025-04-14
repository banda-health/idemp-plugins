package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_BPartner;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_BPartnerQuery extends POQuery<X_I_BPartner> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_BPartner.Table_Name;
	}

	public CompletableFuture<X_I_BPartner> I_BPartner(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_BPartner> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_BPartnerDataLoader.DATALOADER_I_BPartner_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_BPartner> I_BPartnerGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
