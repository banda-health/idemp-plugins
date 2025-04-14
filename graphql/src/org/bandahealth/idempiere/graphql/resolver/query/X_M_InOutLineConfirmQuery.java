package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineConfirmDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutLineConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_InOutLineConfirmQuery extends POQuery<MInOutLineConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutLineConfirm.Table_Name;
	}

	public CompletableFuture<MInOutLineConfirm> M_InOutLineConfirm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInOutLineConfirm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InOutLineConfirmDataLoader.DATALOADER_M_InOutLineConfirm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInOutLineConfirm> M_InOutLineConfirmGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
