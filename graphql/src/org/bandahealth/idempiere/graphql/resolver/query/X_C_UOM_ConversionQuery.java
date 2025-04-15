package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOM_ConversionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUOMConversion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_UOM_ConversionQuery extends POQuery<MUOMConversion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUOMConversion.Table_Name;
	}

	public CompletableFuture<MUOMConversion> C_UOM_Conversion(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUOMConversion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_UOM_ConversionDataLoader.DATALOADER_C_UOM_Conversion_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUOMConversion> C_UOM_ConversionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
