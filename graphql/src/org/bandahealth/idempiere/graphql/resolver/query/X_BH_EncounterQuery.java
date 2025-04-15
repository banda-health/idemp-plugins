package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_EncounterDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_EncounterQuery extends POQuery<MBHEncounter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEncounter.Table_Name;
	}

	public CompletableFuture<MBHEncounter> BH_Encounter(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHEncounter> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_EncounterDataLoader.DATALOADER_BH_Encounter_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHEncounter> BH_EncounterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
