package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProjectIssueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProjectLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProject;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MProjectLine;
import org.compiere.model.MProjectPhase;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MProjectResolver extends X_C_ProjectResolver {

	public CompletableFuture<List<MInvoice_BH>> C_Invoices(MProject entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MInvoice_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MInvoiceDataLoader.DATALOADER_C_Invoice_BY_C_Project_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Project_ID()));
	}

	public CompletableFuture<List<MProjectIssue>> C_ProjectIssues(MProject entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MProjectIssue>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProjectIssueDataLoader.DATALOADER_C_ProjectIssue_BY_C_Project_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Project_ID()));
	}

	public CompletableFuture<List<MProjectLine>> C_ProjectLines(MProject entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MProjectLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProjectLineDataLoader.DATALOADER_C_ProjectLine_BY_C_Project_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Project_ID()));
	}

	public CompletableFuture<List<MProjectPhase>> C_ProjectPhases(MProject entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MProjectPhase>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MProjectPhaseDataLoader.DATALOADER_C_ProjectPhase_BY_C_Project_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_Project_ID()));
	}
}
