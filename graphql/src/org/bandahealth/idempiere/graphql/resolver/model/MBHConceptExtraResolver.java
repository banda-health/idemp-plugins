package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHClientConceptExtraDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHConceptExtraResolver extends X_BH_Concept_ExtraResolver {

	public CompletableFuture<List<MBHClientConceptExtra>> BH_Client_Concept_Extras(MBHConceptExtra entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHClientConceptExtra>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHClientConceptExtraDataLoader.DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_Extra_ID()));
	}
}
