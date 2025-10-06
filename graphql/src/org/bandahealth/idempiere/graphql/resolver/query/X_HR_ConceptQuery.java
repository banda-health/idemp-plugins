package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_ConceptQuery extends POQuery<X_HR_Concept> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept.Table_Name;
	}

	public CompletableFuture<X_HR_Concept> HR_Concept(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Concept> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_ConceptDataLoader.DATALOADER_HR_Concept_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Concept> HR_ConceptGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
