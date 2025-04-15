package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_Processor_TypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPProcessorType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for EXP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_EXP_Processor_TypeQuery extends POQuery<MEXPProcessorType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPProcessorType.Table_Name;
	}

	public CompletableFuture<MEXPProcessorType> EXP_Processor_Type(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MEXPProcessorType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_EXP_Processor_TypeDataLoader.DATALOADER_EXP_Processor_Type_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MEXPProcessorType> EXP_Processor_TypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
