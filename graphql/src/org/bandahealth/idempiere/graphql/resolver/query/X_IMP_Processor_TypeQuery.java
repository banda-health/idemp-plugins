package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_Processor_TypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_IMP_Processor_Type;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_IMP_Processor_TypeQuery extends POQuery<X_IMP_Processor_Type> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_IMP_Processor_Type.Table_Name;
	}

	public CompletableFuture<X_IMP_Processor_Type> IMP_Processor_Type(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_IMP_Processor_Type> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_IMP_Processor_TypeDataLoader.DATALOADER_IMP_Processor_Type_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_IMP_Processor_Type> IMP_Processor_TypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
