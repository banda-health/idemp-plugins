package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_SickOff_Print_LogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_SickOff_Print_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOff_Print_LogQuery extends POQuery<MBHSickOffPrintLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHSickOffPrintLog.Table_Name;
	}

	public CompletableFuture<MBHSickOffPrintLog> BH_SickOff_Print_Log(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHSickOffPrintLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_SickOff_Print_LogDataLoader.DATALOADER_BH_SickOff_Print_Log_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHSickOffPrintLog> BH_SickOff_Print_LogGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
