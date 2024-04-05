package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAttributeValueDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeValue;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAttributeResolver extends X_M_AttributeResolver {

	public CompletableFuture<List<MAttributeValue>> M_AttributeValues(MAttribute entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAttributeValue>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAttributeValueDataLoader.DATALOADER_M_AttributeValue_BY_M_Attribute_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_Attribute_ID()));
	}
}
