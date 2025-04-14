package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_Concept_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept_Category;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_Concept_CategoryQuery extends POQuery<X_HR_Concept_Category> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_Category.Table_Name;
	}

	public CompletableFuture<X_HR_Concept_Category> HR_Concept_Category(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Concept_Category> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_Concept_CategoryDataLoader.DATALOADER_HR_Concept_Category_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Concept_Category> HR_Concept_CategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
