package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_ComponentResolver extends POResolver<MBHPayrollComponent> implements GraphQLResolver<MBHPayrollComponent> {


	public Boolean BH_IsStatutory(MBHPayrollComponent entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsStatutory();
	}

	public Boolean BH_IsTaxDeductible(MBHPayrollComponent entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsTaxDeductible();
	}
}
