package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAttributeUseDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttributeUse;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MAttributeSetResolver extends X_M_AttributeSetResolver {

	public CompletableFuture<List<MAttributeUse>> M_AttributeUseList(MAttributeSet_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAttributeUse>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAttributeUseDataLoader.DATALOADER_M_AttributeUse_BY_M_AttributeSet_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getM_AttributeSet_ID()));
	}
}
