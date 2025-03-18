package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHAllergyReactionDataLoader extends X_BH_Allergy_ReactionDataLoader {
	public static String DATALOADER_BH_Allergy_Reaction_BY_BH_Allergy_ID = "BH_AllergyReactionByBH_AllergyIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Allergy_Reaction_BY_BH_Allergy_ID,
				DataLoader.newMappedDataLoader(getByAllergyIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHAllergyReaction>> getByAllergyIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHAllergyReaction::getBH_Allergy_ID,
				MBHAllergyReaction.COLUMNNAME_BH_Allergy_ID, keys);
	}
}
