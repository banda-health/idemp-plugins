package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPSpecificPayerInfoDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoiceLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MInvoiceLineResolver extends X_C_InvoiceLineResolver {
	public CompletableFuture<List<MBHBPSpecificPayerInfo>> BH_BP_Specific_Payer_InfoList(MInvoiceLine entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPSpecificPayerInfo>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHBPSpecificPayerInfoDataLoader.BH_BP_Specific_Payer_Info_BY_InvoiceLine_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_InvoiceLine_ID()));
	}
}
