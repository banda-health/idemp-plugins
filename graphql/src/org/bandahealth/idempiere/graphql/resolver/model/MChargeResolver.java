package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MChargeAcctDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.X_C_Charge_Acct;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MChargeResolver extends X_C_ChargeResolver {
	public CompletableFuture<List<X_C_Charge_Acct>> C_Charge_AcctList(MCharge_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<X_C_Charge_Acct>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MChargeAcctDataLoader.DATALOADER_C_Charge_Acct_BY_C_Charge_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Charge_ID()));
	}
}
