package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ChargeQuery extends POQuery<MCharge_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCharge_BH.Table_Name;
	}

	public CompletableFuture<MCharge_BH> C_Charge(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCharge_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCharge_BH> C_ChargeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
