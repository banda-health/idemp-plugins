package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHClientConceptExtraDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class MBHConceptExtraResolver extends X_BH_Concept_ExtraResolver {

	public CompletableFuture<MBHClientConceptExtra> BH_Client_Concept_Extra(MBHConceptExtra entity,
			DataFetchingEnvironment environment) {
		DataLoader<Integer, MBHClientConceptExtra> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHClientConceptExtraDataLoader.DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID);
		return dataLoader.load(entity.getBH_Concept_Extra_ID());
	}
}
