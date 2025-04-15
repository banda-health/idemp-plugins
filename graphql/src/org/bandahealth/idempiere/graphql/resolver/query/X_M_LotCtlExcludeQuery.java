package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotCtlExcludeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLotCtlExclude;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LotCtlExcludeQuery extends POQuery<MLotCtlExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLotCtlExclude.Table_Name;
	}

	public CompletableFuture<MLotCtlExclude> M_LotCtlExclude(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLotCtlExclude> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_LotCtlExcludeDataLoader.DATALOADER_M_LotCtlExclude_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLotCtlExclude> M_LotCtlExcludeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
