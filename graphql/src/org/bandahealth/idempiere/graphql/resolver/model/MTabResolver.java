package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MFieldDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MTab;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MTabResolver extends X_AD_TabResolver {

	public CompletableFuture<List<MField_BH>> AD_Fields(MTab entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MField_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MFieldDataLoader.DATALOADER_AD_Field_BY_AD_Tab_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Tab_ID()));
	}
}
