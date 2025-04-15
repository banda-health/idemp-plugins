package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ChargeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ChargeTypeQuery extends POQuery<MChargeType_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChargeType_BH.Table_Name;
	}

	public CompletableFuture<MChargeType_BH> C_ChargeType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MChargeType_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ChargeTypeDataLoader.DATALOADER_C_ChargeType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MChargeType_BH> C_ChargeTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
