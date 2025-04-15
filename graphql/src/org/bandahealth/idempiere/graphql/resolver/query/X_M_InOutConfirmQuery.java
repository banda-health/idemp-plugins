package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutConfirmDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InOutConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InOutConfirmQuery extends POQuery<MInOutConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutConfirm.Table_Name;
	}

	public CompletableFuture<MInOutConfirm> M_InOutConfirm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInOutConfirm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InOutConfirmDataLoader.DATALOADER_M_InOutConfirm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInOutConfirm> M_InOutConfirmGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
