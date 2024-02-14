package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHVisitResolver extends X_BH_VisitResolver {
	public CompletableFuture<List<MBHEncounter>> BH_Encounters(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MBHEncounter>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterDataLoader.DATALOADER_BH_Encounter_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MInvoice_BH>> C_Invoices(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MInvoice_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInvoiceDataLoader.DATALOADER_C_Invoice_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MOrder_BH>> C_Orders(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MOrder_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrderDataLoader.DATALOADER_C_Order_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MPayment_BH>> C_Payments(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MPayment_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MPaymentDataLoader.DATALOADER_C_Payment_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MInOut_BH>> M_InOuts(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MInOut_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInOutDataLoader.DATALOADER_M_InOut_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}
}
