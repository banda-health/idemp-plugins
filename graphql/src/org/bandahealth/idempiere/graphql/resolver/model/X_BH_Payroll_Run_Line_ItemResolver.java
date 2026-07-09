package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_Run_LineDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_Line_ItemResolver extends POResolver<MBHPayrollRunLineItem> implements GraphQLResolver<MBHPayrollRunLineItem> {


	public Boolean BH_IsTaxDeductible(MBHPayrollRunLineItem entity, DataFetchingEnvironment environment) {
		return entity.isBH_IsTaxDeductible();
	}

	/**
	 * Get Payroll Run Line.
	 *
	 * @return Payroll Run Line
	 */
	public CompletableFuture<MBHPayrollRunLine> BH_Payroll_Run_Line(MBHPayrollRunLineItem entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Run_Line_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollRunLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_Run_LineDataLoader.DATALOADER_BH_Payroll_Run_Line_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Run_Line_ID());
	}
}
