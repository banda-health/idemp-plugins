package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_DocTypeQuery extends POQuery<MDocType_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDocType_BH.Table_Name;
	}

	public CompletableFuture<MDocType_BH> C_DocType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDocType_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDocType_BH> C_DocTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
