package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_InOutLineConfirmDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_InOutLineConfirm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_InOutLineConfirmQuery extends POQuery<X_I_InOutLineConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_InOutLineConfirm.Table_Name;
	}

	public CompletableFuture<X_I_InOutLineConfirm> I_InOutLineConfirm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_InOutLineConfirm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_InOutLineConfirmDataLoader.DATALOADER_I_InOutLineConfirm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_InOutLineConfirm> I_InOutLineConfirmGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
