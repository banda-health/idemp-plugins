package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MConversionType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ConversionTypeQuery extends POQuery<MConversionType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MConversionType.Table_Name;
	}

	public CompletableFuture<MConversionType> C_ConversionType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MConversionType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MConversionType> C_ConversionTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
