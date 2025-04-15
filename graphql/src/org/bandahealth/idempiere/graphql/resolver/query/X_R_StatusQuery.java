package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatus;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_StatusQuery extends POQuery<MStatus> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatus.Table_Name;
	}

	public CompletableFuture<MStatus> R_Status(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStatus> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_StatusDataLoader.DATALOADER_R_Status_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStatus> R_StatusGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
