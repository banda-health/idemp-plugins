package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_WorkfileDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationWorkfile;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_WorkfileQuery extends POQuery<MDepreciationWorkfile> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationWorkfile.Table_Name;
	}

	public CompletableFuture<MDepreciationWorkfile> A_Depreciation_Workfile(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciationWorkfile> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_WorkfileDataLoader.DATALOADER_A_Depreciation_Workfile_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciationWorkfile> A_Depreciation_WorkfileGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
