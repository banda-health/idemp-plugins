package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPackageExpDetailDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPackageExp;
import org.compiere.model.MPackageExpDetail;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPackageExpResolver extends X_AD_Package_ExpResolver {

	public CompletableFuture<List<MPackageExpDetail>> AD_Package_Exp_DetailList(MPackageExp entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPackageExpDetail>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPackageExpDetailDataLoader.DATALOADER_AD_Package_Exp_Detail_BY_AD_Package_Exp_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Package_Exp_ID()));
	}
}
