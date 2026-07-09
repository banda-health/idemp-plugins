package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPAYEBand;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MBHPAYEBandDataLoader extends X_BH_PAYE_BandDataLoader {
	public static String DATALOADER_BH_PAYE_Band_BY_BH_Payroll_Component_ID =
			"DATALOADER_BH_PAYE_Band_BY_BH_Payroll_Component_ID";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_BH_PAYE_Band_BY_BH_Payroll_Component_ID,
				DataLoader.newMappedDataLoader(getByBHPayrollComponentIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MBHPAYEBand>> getByBHPayrollComponentIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MBHPAYEBand::getBH_Payroll_Component_ID,
				MBHPAYEBand.COLUMNNAME_BH_Payroll_Component_ID, keys);
	}
}
