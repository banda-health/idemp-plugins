package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_GroupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGroup;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_GroupQuery extends POQuery<MGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGroup.Table_Name;
	}

	public CompletableFuture<MGroup> R_Group(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MGroup> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_GroupDataLoader.DATALOADER_R_Group_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MGroup> R_GroupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
