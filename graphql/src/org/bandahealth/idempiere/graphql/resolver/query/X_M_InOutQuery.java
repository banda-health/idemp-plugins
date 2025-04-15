package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InOutQuery extends POQuery<MInOut_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOut_BH.Table_Name;
	}

	public CompletableFuture<MInOut_BH> M_InOut(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInOut_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InOutDataLoader.DATALOADER_M_InOut_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInOut_BH> M_InOutGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
