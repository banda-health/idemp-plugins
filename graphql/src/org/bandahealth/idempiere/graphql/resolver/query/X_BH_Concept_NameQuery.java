package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Concept_NameDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Concept_Name - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Concept_NameQuery extends POQuery<MBHConceptName> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHConceptName.Table_Name;
	}

	public CompletableFuture<MBHConceptName> BH_Concept_Name(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHConceptName> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Concept_NameDataLoader.DATALOADER_BH_Concept_Name_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHConceptName> BH_Concept_NameGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
