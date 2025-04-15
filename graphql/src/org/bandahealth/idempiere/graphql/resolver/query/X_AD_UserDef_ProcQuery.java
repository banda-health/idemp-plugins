package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_ProcDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefProc;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserDef_ProcQuery extends POQuery<MUserDefProc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefProc.Table_Name;
	}

	public CompletableFuture<MUserDefProc> AD_UserDef_Proc(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefProc> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_ProcDataLoader.DATALOADER_AD_UserDef_Proc_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefProc> AD_UserDef_ProcGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
