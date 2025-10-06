package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ReferenceQuery extends POQuery<MReference_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReference_BH.Table_Name;
	}

	public CompletableFuture<MReference_BH> AD_Reference(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReference_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReference_BH> AD_ReferenceGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
