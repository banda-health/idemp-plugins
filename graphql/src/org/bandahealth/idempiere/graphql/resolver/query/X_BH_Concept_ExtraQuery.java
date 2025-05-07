package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Concept_ExtraDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Concept_ExtraQuery extends POQuery<MBHConceptExtra> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHConceptExtra.Table_Name;
	}

	public CompletableFuture<MBHConceptExtra> BH_Concept_Extra(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHConceptExtra> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Concept_ExtraDataLoader.DATALOADER_BH_Concept_Extra_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHConceptExtra> BH_Concept_ExtraGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
