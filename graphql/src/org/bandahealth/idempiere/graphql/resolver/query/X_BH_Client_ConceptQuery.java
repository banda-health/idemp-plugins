package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Client_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Client_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Client_ConceptQuery extends POQuery<MBHClientConcept> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHClientConcept.Table_Name;
	}

	public CompletableFuture<MBHClientConcept> BH_Client_Concept(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHClientConcept> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Client_ConceptDataLoader.DATALOADER_BH_Client_Concept_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHClientConcept> BH_Client_ConceptGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
