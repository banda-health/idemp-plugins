package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportCubeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReportCube;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_ReportCubeQuery extends POQuery<MReportCube> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReportCube.Table_Name;
	}

	public CompletableFuture<MReportCube> PA_ReportCube(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MReportCube> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ReportCubeDataLoader.DATALOADER_PA_ReportCube_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MReportCube> PA_ReportCubeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
