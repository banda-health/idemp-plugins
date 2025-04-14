package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_Fact_AcctDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineDataLoader;
import org.compiere.model.MFactAcct;
import org.compiere.model.MPInstance;
import org.compiere.model.X_T_Report;
import org.compiere.report.MReportLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_ReportResolver extends POResolver<X_T_Report> implements GraphQLResolver<X_T_Report> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_Report entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MFactAcct> Fact_Acct(X_T_Report entity, DataFetchingEnvironment environment) {
		if (entity.getFact_Acct_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFactAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_Fact_AcctDataLoader.DATALOADER_Fact_Acct_BY_ID);
		return dataLoader.load(entity.getFact_Acct_ID());
	}


	/**
	 * Get Report Line.
	 *
	 * @return Report Line
	 */
	public CompletableFuture<MReportLine> PA_ReportLine(X_T_Report entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.DATALOADER_PA_ReportLine_BY_ID);
		return dataLoader.load(entity.getPA_ReportLine_ID());
	}

}
