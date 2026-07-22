package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MBHPAYEBand;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPAYEBandDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBHPayrollComponentResolver extends X_BH_Payroll_ComponentResolver {

	public CompletableFuture<List<MBHPAYEBand>> BH_PAYE_Bands(MBHPayrollComponent entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPAYEBand>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHPAYEBandDataLoader.DATALOADER_BH_PAYE_Band_BY_BH_Payroll_Component_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.get_ID()));
	}
}
