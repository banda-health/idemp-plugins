package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollFiling;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_RunDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Filing - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_FilingResolver extends POResolver<MBHPayrollFiling> implements GraphQLResolver<MBHPayrollFiling> {


	public Boolean BH_IsPaid(MBHPayrollFiling entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsPaid();
	}

	/**
	 * Get Payroll Run.
	 *
	 * @return Payroll Run
	 */
	public CompletableFuture<MBHPayrollRun> BH_Payroll_Run(MBHPayrollFiling entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Run_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_RunDataLoader.DATALOADER_BH_Payroll_Run_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Run_ID());
	}
}
