package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AddressValidationCfgDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_AddressValidationCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AddressValidationCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressValidationCfgQuery extends POQuery<X_C_AddressValidationCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressValidationCfg.Table_Name;
	}

	public CompletableFuture<X_C_AddressValidationCfg> C_AddressValidationCfg(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_AddressValidationCfg> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AddressValidationCfgDataLoader.DATALOADER_C_AddressValidationCfg_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_AddressValidationCfg> C_AddressValidationCfgGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
