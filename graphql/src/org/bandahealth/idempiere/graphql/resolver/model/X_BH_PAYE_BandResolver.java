package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPAYEBand;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_ComponentDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_PAYE_Band - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_PAYE_BandResolver extends POResolver<MBHPAYEBand> implements GraphQLResolver<MBHPAYEBand> {


	/**
	 * Get Payroll Component.
	 *
	 * @return Payroll Component
	 */
	public CompletableFuture<MBHPayrollComponent> BH_Payroll_Component(MBHPAYEBand entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Component_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollComponent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_ComponentDataLoader.DATALOADER_BH_Payroll_Component_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Component_ID());
	}
}
