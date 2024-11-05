package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_Fact_AcctDataLoader;
import org.compiere.model.MFactAcct;
import org.compiere.model.MPInstance;
import org.compiere.model.X_T_ReportStatement;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_ReportStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_ReportStatementResolver extends POResolver<X_T_ReportStatement> implements GraphQLResolver<X_T_ReportStatement> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_ReportStatement entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Accounting Fact.
	 *
	 * @return Accounting Fact
	 */
	public CompletableFuture<MFactAcct> Fact_Acct(X_T_ReportStatement entity, DataFetchingEnvironment environment) {
		if (entity.getFact_Acct_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFactAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_Fact_AcctDataLoader.DATALOADER_Fact_Acct_BY_ID);
		return dataLoader.load(entity.getFact_Acct_ID());
	}

}
