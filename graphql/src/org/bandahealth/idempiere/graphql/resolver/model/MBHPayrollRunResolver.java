package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayrollFilingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayrollRunLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHPayrollRunResolver extends X_BH_Payroll_RunResolver {

	public CompletableFuture<List<MBHPayrollFiling>> BH_Payroll_Filings(MBHPayrollRun entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPayrollFiling>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHPayrollFilingDataLoader.DATALOADER_BH_Payroll_Filing_BY_BH_Payroll_Run_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}

	public CompletableFuture<List<MBHPayrollRunLine>> BH_Payroll_Run_Lines(MBHPayrollRun entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPayrollRunLine>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHPayrollRunLineDataLoader.DATALOADER_BH_Payroll_Run_Line_BY_BH_Payroll_Run_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
