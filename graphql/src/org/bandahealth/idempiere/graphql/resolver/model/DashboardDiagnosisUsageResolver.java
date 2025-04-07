package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.model.DashboardDiagnosisUsage;
import org.bandahealth.idempiere.graphql.model.InventoryTransaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class DashboardDiagnosisUsageResolver implements GraphQLResolver<DashboardDiagnosisUsage> {

	public CompletableFuture<MBHConcept> BH_Concept(DashboardDiagnosisUsage Entity,
			DataFetchingEnvironment environment) {
		if (Entity.getConceptId() == null || Entity.getConceptId() < 1) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(Entity.getConceptId());
	}
}
