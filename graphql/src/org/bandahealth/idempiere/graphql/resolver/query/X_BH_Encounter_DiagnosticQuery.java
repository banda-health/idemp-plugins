package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Encounter_DiagnosticDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Encounter_Diagnostic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_DiagnosticQuery extends POQuery<MBHEncounterDiagnostic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEncounterDiagnostic.Table_Name;
	}

	public CompletableFuture<MBHEncounterDiagnostic> BH_Encounter_Diagnostic(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHEncounterDiagnostic> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Encounter_DiagnosticDataLoader.DATALOADER_BH_Encounter_Diagnostic_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHEncounterDiagnostic> BH_Encounter_DiagnosticGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
