package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProject;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectQuery extends POQuery<MProject> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProject.Table_Name;
	}

	public CompletableFuture<MProject> C_Project(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProject> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProject> C_ProjectGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
