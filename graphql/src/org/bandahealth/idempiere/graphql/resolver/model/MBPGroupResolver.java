package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MChargeDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class MBPGroupResolver extends X_C_BP_GroupResolver {
	public CompletableFuture<MCharge_BH> AssociatedCustomerReceivablesCharge(MBPGroup_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, MCharge_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MChargeDataLoader.C_Charge_ASSOCIATED_CUSTOMER_RECEIVABLE_BY_BPARTNER_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
