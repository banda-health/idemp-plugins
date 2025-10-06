package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_SerNoCtlDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_SerNoCtlQuery extends POQuery<MSerNoCtl_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSerNoCtl_BH.Table_Name;
	}

	public CompletableFuture<MSerNoCtl_BH> M_SerNoCtl(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSerNoCtl_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_SerNoCtlDataLoader.DATALOADER_M_SerNoCtl_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSerNoCtl_BH> M_SerNoCtlGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
