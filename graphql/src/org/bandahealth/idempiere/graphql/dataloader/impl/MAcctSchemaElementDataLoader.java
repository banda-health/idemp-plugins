package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MAcctSchemaElement;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MAcctSchemaElementDataLoader extends X_C_AcctSchema_ElementDataLoader {
	public static String DATALOADER_C_AcctSchema_Element_BY_C_AcctSchema_ID =
			"DATALOADER_C_AcctSchema_Element_BY_C_AcctSchema_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_C_AcctSchema_Element_BY_C_AcctSchema_ID,
				DataLoader.newMappedDataLoader(getByAcctSchemaIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MAcctSchemaElement>> getByAcctSchemaIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MAcctSchemaElement::getC_AcctSchema_ID,
				MAcctSchemaElement.COLUMNNAME_C_AcctSchema_ID, keys);
	}
}
