package org.bandahealth.idempiere.graphql.resolver.model;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHClientConceptExtraDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import graphql.schema.DataFetchingEnvironment;

public class MBHConceptExtraResolver extends X_BH_Concept_ExtraResolver {
	// Fetch MBHClientConceptExtra entities associated with a given MBHConceptExtra entity
    public CompletableFuture<List<MBHClientConceptExtra>> BH_Client_Concept_Extras(MBHConceptExtra entity,
            DataFetchingEnvironment environment) {
        
        // Retrieve the DataLoader from the DataLoaderRegistry using the specific loader key
        DataLoader<String, List<MBHClientConceptExtra>> dataLoader = environment.getDataLoaderRegistry()
                .getDataLoader(MBHClientConceptExtraDataLoader.DATALOADER_BH_Client_Concept_Extra_BY_Concept_Extra_ID);
        
        // Use the data loader to load the data asynchronously based on the model key generated from the entity
        return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Concept_Extra_ID()));
    }
}
