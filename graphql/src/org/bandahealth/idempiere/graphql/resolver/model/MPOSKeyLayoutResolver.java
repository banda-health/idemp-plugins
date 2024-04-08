package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPOSKeyDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPOSKey;
import org.compiere.model.MPOSKeyLayout;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPOSKeyLayoutResolver extends X_C_POSKeyLayoutResolver {

	public CompletableFuture<List<MPOSKey>> C_POSKeys(MPOSKeyLayout entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MPOSKey>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPOSKeyDataLoader.DATALOADER_C_POSKey_BY_C_POSKeyLayout_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_POSKeyLayout_ID()));
	}
}
