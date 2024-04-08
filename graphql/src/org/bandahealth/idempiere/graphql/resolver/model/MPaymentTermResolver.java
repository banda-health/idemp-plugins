package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPayScheduleDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPaySchedule;
import org.compiere.model.MPaymentTerm;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MPaymentTermResolver extends X_C_PaymentTermResolver {

	public CompletableFuture<List<MPaySchedule>> C_PayScheduleList(MPaymentTerm entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPaySchedule>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPayScheduleDataLoader.DATALOADER_C_PaySchedule_BY_C_PaymentTerm_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_PaymentTerm_ID()));
	}
}
