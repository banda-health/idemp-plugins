package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_ExpDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationExp;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_ExpQuery extends POQuery<MDepreciationExp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationExp.Table_Name;
	}

	public CompletableFuture<MDepreciationExp> A_Depreciation_Exp(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciationExp> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_ExpDataLoader.DATALOADER_A_Depreciation_Exp_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciationExp> A_Depreciation_ExpGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
