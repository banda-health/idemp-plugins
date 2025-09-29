package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChangeNotice;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ChangeNotice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ChangeNoticeQuery extends POQuery<MChangeNotice> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChangeNotice.Table_Name;
	}

	public CompletableFuture<MChangeNotice> M_ChangeNotice(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChangeNotice> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChangeNotice> M_ChangeNoticeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
