package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MBHConceptDataLoader extends X_BH_ConceptDataLoader {
		public static String DATALOADER_BH_Concept_BY_BH_OclID = "DATALOADER_BH_Concept_BY_BH_OclID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Concept_BY_BH_OclID,
				DataLoader.newMappedDataLoader(getByOclIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, MBHConcept> getByOclIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			List<Object> parameters = new ArrayList<>();
			String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(keys, parameters);
			Repository.setCopyOfPropertiesForNestedThreadUsage(batchLoaderEnvironment.getContext());
			List<MBHConcept> models =
					Repository.getQuery(batchLoaderEnvironment.getContext(), getTableName(), null, true, false,
							getTableName() + "." + MBHConcept.COLUMNNAME_BH_OclID + " IN (" + whereCondition +
									")", parameters).list();
			return models.stream().collect(Collectors.toMap(MBHConcept::getBH_OclID, concept -> concept));
		});
	}
}
