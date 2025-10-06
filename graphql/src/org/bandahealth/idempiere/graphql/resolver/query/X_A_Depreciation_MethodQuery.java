package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_MethodDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationMethod;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_MethodQuery extends POQuery<MDepreciationMethod> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationMethod.Table_Name;
	}

	public CompletableFuture<MDepreciationMethod> A_Depreciation_Method(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciationMethod> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_MethodDataLoader.DATALOADER_A_Depreciation_Method_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciationMethod> A_Depreciation_MethodGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
