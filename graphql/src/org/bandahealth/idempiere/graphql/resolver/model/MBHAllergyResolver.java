package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHAllergyReactionDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHAllergyResolver extends X_BH_AllergyResolver {

	public CompletableFuture<List<MBHAllergyReaction>> BH_Allergy_Reactions(MBHAllergy entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHAllergyReaction>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHAllergyReactionDataLoader.DATALOADER_BH_Allergy_Reaction_BY_BH_Allergy_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Allergy_ID()));
	}
}
