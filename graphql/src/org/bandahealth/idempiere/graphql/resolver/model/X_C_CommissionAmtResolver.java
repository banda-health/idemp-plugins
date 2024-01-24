package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionRunDataLoader;
import org.compiere.model.MCommissionAmt;
import org.compiere.model.MCommissionLine;
import org.compiere.model.MCommissionRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionAmtResolver extends POResolver<MCommissionAmt> implements GraphQLResolver<MCommissionAmt> {



	/**
	 * Get Commission Line.
	 *
	 * @return Commission Line
	 */
	public CompletableFuture<MCommissionLine> C_CommissionLine(MCommissionAmt entity, DataFetchingEnvironment environment) {
		if (entity.getC_CommissionLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCommissionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CommissionLineDataLoader.DATALOADER_C_CommissionLine_BY_ID);
		return dataLoader.load(entity.getC_CommissionLine_ID());
	}


	/**
	 * Get Commission Run.
	 *
	 * @return Commission Run or Process
	 */
	public CompletableFuture<MCommissionRun> C_CommissionRun(MCommissionAmt entity, DataFetchingEnvironment environment) {
		if (entity.getC_CommissionRun_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCommissionRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CommissionRunDataLoader.DATALOADER_C_CommissionRun_BY_ID);
		return dataLoader.load(entity.getC_CommissionRun_ID());
	}

}
