package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Encounter_Type_WindowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_Type_WindowQuery extends POQuery<MBHEncounterTypeWindow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEncounterTypeWindow.Table_Name;
	}

	public CompletableFuture<MBHEncounterTypeWindow> BH_Encounter_Type_Window(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHEncounterTypeWindow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Encounter_Type_WindowDataLoader.DATALOADER_BH_Encounter_Type_Window_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHEncounterTypeWindow> BH_Encounter_Type_WindowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
