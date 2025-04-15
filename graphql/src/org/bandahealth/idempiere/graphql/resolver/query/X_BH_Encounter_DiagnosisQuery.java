package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Encounter_DiagnosisDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_DiagnosisQuery extends POQuery<MBHEncounterDiagnosis> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHEncounterDiagnosis.Table_Name;
	}

	public CompletableFuture<MBHEncounterDiagnosis> BH_Encounter_Diagnosis(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHEncounterDiagnosis> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Encounter_DiagnosisDataLoader.DATALOADER_BH_Encounter_Diagnosis_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHEncounterDiagnosis> BH_Encounter_DiagnosisGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
