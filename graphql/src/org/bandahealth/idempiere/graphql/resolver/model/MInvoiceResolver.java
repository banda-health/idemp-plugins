package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MAllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceTaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MInvoiceTax;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInvoiceResolver extends X_C_InvoiceResolver {
	public CompletableFuture<List<MPayment_BH>> BH_Original_C_Payments(MInvoice_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MPayment_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MPaymentDataLoader.DATALOADER_C_Payment_BY_BH_Original_C_Invoice_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Invoice_ID()));
	}

	public CompletableFuture<List<MAllocationLine>> C_AllocationLines(MInvoice_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MAllocationLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MAllocationLineDataLoader.DATALOADER_C_AllocationLine_BY_C_Invoice_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Invoice_ID()));
	}

	public CompletableFuture<List<MInvoiceLine>> C_InvoiceLines(MInvoice_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInvoiceLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInvoiceLineDataLoader.DATALOADER_C_InvoiceLine_BY_C_Invoice_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Invoice_ID()));
	}

	public CompletableFuture<List<MInvoiceTax>> C_InvoiceTaxes(MInvoice_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInvoiceTax>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInvoiceTaxDataLoader.DATALOADER_C_InvoiceTax_BY_C_Invoice_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Invoice_ID()));
	}
}
