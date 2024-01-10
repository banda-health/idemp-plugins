package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrgDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MClientResolver extends X_AD_ClientResolver {

	public CompletableFuture<List<MOrg>> AD_Orgs(MClient_BH entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MOrg>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrgDataLoader.AD_Org_BY_CLIENT_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Client_ID()));
	}
}
