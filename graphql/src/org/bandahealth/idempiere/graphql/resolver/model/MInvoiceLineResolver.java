package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPSpecificPayerInfoDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MLandedCostAllocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MLandedCostDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MMatchInvDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLandedCost;
import org.compiere.model.MLandedCostAllocation;
import org.compiere.model.MMatchInv;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInvoiceLineResolver extends X_C_InvoiceLineResolver {
	public CompletableFuture<List<MBHBPSpecificPayerInfo>> BH_BP_Specific_Payer_InfoList(MInvoiceLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPSpecificPayerInfo>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHBPSpecificPayerInfoDataLoader.DATALOADER_BH_BP_Specific_Payer_Info_BY_C_InvoiceLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_InvoiceLine_ID()));
	}

	public CompletableFuture<List<MLandedCost>> C_LandedCostList(MInvoiceLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MLandedCost>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MLandedCostDataLoader.DATALOADER_C_LandedCost_BY_C_InvoiceLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_InvoiceLine_ID()));
	}

	public CompletableFuture<List<MLandedCostAllocation>> C_LandedCostAllocationList(MInvoiceLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MLandedCostAllocation>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MLandedCostAllocationDataLoader.DATALOADER_C_LandedCostAllocation_BY_C_InvoiceLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_InvoiceLine_ID()));
	}

	public CompletableFuture<List<MMatchInv>> M_MatchInvList(MInvoiceLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MMatchInv>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MMatchInvDataLoader.DATALOADER_M_MatchInv_BY_C_InvoiceLine_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_InvoiceLine_ID()));
	}
}
