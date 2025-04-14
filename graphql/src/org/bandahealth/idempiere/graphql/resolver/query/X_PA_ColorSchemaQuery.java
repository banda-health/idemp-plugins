package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ColorSchemaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColorSchema;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_ColorSchemaQuery extends POQuery<MColorSchema> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColorSchema.Table_Name;
	}

	public CompletableFuture<MColorSchema> PA_ColorSchema(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MColorSchema> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_ColorSchemaDataLoader.DATALOADER_PA_ColorSchema_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MColorSchema> PA_ColorSchemaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
