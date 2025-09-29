package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutLineMA;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InOutLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InOutLineMAQuery extends POQuery<MInOutLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutLineMA.Table_Name;
	}

	public CompletableFuture<MInOutLineMA> M_InOutLineMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInOutLineMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InOutLineMADataLoader.DATALOADER_M_InOutLineMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInOutLineMA> M_InOutLineMAGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
