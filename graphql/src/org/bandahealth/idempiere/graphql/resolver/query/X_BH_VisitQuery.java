package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_VisitQuery extends POQuery<MBHVisit> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHVisit.Table_Name;
	}

	public CompletableFuture<MBHVisit> BH_Visit(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHVisit> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_VisitDataLoader.DATALOADER_BH_Visit_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHVisit> BH_VisitGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
