package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Concept_MappingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Concept_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Concept_MappingQuery extends POQuery<MBHConceptMapping> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHConceptMapping.Table_Name;
	}

	public CompletableFuture<MBHConceptMapping> BH_Concept_Mapping(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHConceptMapping> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Concept_MappingDataLoader.DATALOADER_BH_Concept_Mapping_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHConceptMapping> BH_Concept_MappingGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
