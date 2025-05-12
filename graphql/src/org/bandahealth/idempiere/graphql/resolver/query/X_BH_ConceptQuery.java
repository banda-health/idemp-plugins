package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_ConceptQuery extends POQuery<MBHConcept> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHConcept.Table_Name;
	}

	public CompletableFuture<MBHConcept> BH_Concept(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHConcept> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHConcept> BH_ConceptGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
