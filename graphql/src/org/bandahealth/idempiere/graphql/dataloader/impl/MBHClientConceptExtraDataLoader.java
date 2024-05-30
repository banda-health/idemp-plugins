package org.bandahealth.idempiere.graphql.dataloader.impl;

import java.util.List;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

/**
 * Provide custom data loading for the MBHClientConceptExtra class
 */
public class MBHClientConceptExtraDataLoader extends X_BH_Client_Concept_ExtraDataLoader {

	// Constant key for the data loader that loads BH_Client_Concept_Extra data by
	// Concept_Extra_ID
	public static String DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID = "DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID";

	// Override the register method to add custom data loader registration logic
	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);

		// Register a new mapped data loader with the registry for loading data by
		// Concept_Extra_ID
		registry.register(DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID, DataLoader
				.newMappedDataLoader(getByConceptExtraIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHClientConceptExtra>> getByConceptExtraIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				// Pass the context from the batch loader environment
				batchLoaderEnvironment.getContext(),
				// Get the table name for the query
				getTableName(),
				// No transaction used
				null,
				// Pass a functional interface to get the BH_Concept_Extra_ID
				MBHClientConceptExtra::getBH_Concept_Extra_ID,
				// Specify the column name for BH_Concept_Extra_ID
				MBHClientConceptExtra.COLUMNNAME_BH_Concept_Extra_ID,
				// Pass the keys to the repository method
				keys);
	}
}
