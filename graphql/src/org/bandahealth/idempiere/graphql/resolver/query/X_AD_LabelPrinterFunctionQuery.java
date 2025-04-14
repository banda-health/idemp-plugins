package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LabelPrinterFunctionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_LabelPrinterFunction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_LabelPrinterFunctionQuery extends POQuery<X_AD_LabelPrinterFunction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_LabelPrinterFunction.Table_Name;
	}

	public CompletableFuture<X_AD_LabelPrinterFunction> AD_LabelPrinterFunction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_LabelPrinterFunction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_LabelPrinterFunctionDataLoader.DATALOADER_AD_LabelPrinterFunction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_LabelPrinterFunction> AD_LabelPrinterFunctionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
