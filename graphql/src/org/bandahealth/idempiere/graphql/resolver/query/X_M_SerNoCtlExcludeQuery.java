package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_SerNoCtlExcludeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSerNoCtlExclude;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_SerNoCtlExcludeQuery extends POQuery<MSerNoCtlExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSerNoCtlExclude.Table_Name;
	}

	public CompletableFuture<MSerNoCtlExclude> M_SerNoCtlExclude(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSerNoCtlExclude> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_SerNoCtlExcludeDataLoader.DATALOADER_M_SerNoCtlExclude_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSerNoCtlExclude> M_SerNoCtlExcludeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
