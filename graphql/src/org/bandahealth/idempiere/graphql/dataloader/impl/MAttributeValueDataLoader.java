package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAttributeValue;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAttributeValueDataLoader extends X_M_AttributeValueDataLoader {
	public static String DATALOADER_M_AttributeValue_BY_M_Attribute_ID = "DATALOADER_M_AttributeValue_BY_M_Attribute_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_M_AttributeValue_BY_M_Attribute_ID,
				DataLoader.newMappedDataLoader(getByAttributeIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAttributeValue>> getByAttributeIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAttributeValue::getM_Attribute_ID,
				MAttributeValue.COLUMNNAME_M_Attribute_ID, keys);
	}
}
