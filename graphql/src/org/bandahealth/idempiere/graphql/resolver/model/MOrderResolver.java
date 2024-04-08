package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderLandedCostDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderTaxDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderLandedCost;
import org.compiere.model.MOrderTax;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MOrderResolver extends X_C_OrderResolver {

	public CompletableFuture<List<MInvoice_BH>> C_Invoices(MOrder_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MInvoice_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInvoiceDataLoader.DATALOADER_C_Invoice_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public CompletableFuture<List<MOrderLandedCost>> C_OrderLandedCostList(MOrder_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MOrderLandedCost>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MOrderLandedCostDataLoader.DATALOADER_C_OrderLandedCost_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public CompletableFuture<List<MOrderTax>> C_OrderTaxList(MOrder_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MOrderTax>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MOrderTaxDataLoader.DATALOADER_C_OrderTax_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public CompletableFuture<List<MOrderLine_BH>> C_OrderLines(MOrder_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MOrderLine_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrderLineDataLoader.DATALOADER_C_OrderLine_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}

	public CompletableFuture<List<MInOut_BH>> M_InOuts(MOrder_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MInOut_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInOutDataLoader.DATALOADER_M_InOut_BY_C_Order_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Order_ID()));
	}
}
