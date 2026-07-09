package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPayrollRunLineDataLoader extends X_BH_Payroll_Run_LineDataLoader {
	public static String DATALOADER_BH_Payroll_Run_Line_BY_BH_Payroll_Run_ID =
			"DATALOADER_BH_Payroll_Run_Line_BY_BH_Payroll_Run_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Payroll_Run_Line_BY_BH_Payroll_Run_ID,
				DataLoader.newMappedDataLoader(getByBHPayrollRunIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPayrollRunLine>> getByBHPayrollRunIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPayrollRunLine::getBH_Payroll_Run_ID,
				MBHPayrollRunLine.COLUMNNAME_BH_Payroll_Run_ID, keys);
	}
}
