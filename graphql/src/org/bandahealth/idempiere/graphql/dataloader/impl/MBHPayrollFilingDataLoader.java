package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPayrollFilingDataLoader extends X_BH_Payroll_FilingDataLoader {
	public static String DATALOADER_BH_Payroll_Filing_BY_BH_Payroll_Run_ID =
			"DATALOADER_BH_Payroll_Filing_BY_BH_Payroll_Run_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_Payroll_Filing_BY_BH_Payroll_Run_ID,
				DataLoader.newMappedDataLoader(getByBHPayrollRunIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPayrollFiling>> getByBHPayrollRunIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPayrollFiling::getBH_Payroll_Run_ID,
				MBHPayrollFiling.COLUMNNAME_BH_Payroll_Run_ID, keys);
	}
}
