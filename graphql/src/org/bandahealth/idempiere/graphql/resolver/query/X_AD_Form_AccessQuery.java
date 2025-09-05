package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Form_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFormAccess;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Form_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Form_AccessQuery extends POQuery<MFormAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFormAccess.Table_Name;
	}

	public CompletableFuture<MFormAccess> AD_Form_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFormAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Form_AccessDataLoader.DATALOADER_AD_Form_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFormAccess> AD_Form_AccessGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
