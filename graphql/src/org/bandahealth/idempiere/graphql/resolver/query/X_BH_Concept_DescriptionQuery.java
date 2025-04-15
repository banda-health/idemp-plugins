package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Concept_DescriptionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Concept_Description - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Concept_DescriptionQuery extends POQuery<MBHConceptDescription> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHConceptDescription.Table_Name;
	}

	public CompletableFuture<MBHConceptDescription> BH_Concept_Description(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHConceptDescription> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Concept_DescriptionDataLoader.DATALOADER_BH_Concept_Description_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHConceptDescription> BH_Concept_DescriptionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
