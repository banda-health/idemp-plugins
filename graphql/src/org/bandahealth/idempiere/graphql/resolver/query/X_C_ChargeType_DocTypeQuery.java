package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeType_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ChargeType_DocType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ChargeType_DocTypeQuery extends POQuery<X_C_ChargeType_DocType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeType_DocType.Table_Name;
	}

	public CompletableFuture<X_C_ChargeType_DocType> C_ChargeType_DocType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_ChargeType_DocType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ChargeType_DocTypeDataLoader.DATALOADER_C_ChargeType_DocType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_ChargeType_DocType> C_ChargeType_DocTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
