package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_InterestAreaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInterestArea;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_InterestArea - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_InterestAreaQuery extends POQuery<MInterestArea> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInterestArea.Table_Name;
	}

	public CompletableFuture<MInterestArea> R_InterestArea(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInterestArea> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_InterestAreaDataLoader.DATALOADER_R_InterestArea_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInterestArea> R_InterestAreaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
